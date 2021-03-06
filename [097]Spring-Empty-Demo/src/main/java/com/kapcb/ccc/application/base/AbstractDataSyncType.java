import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a>Title: AbstractDataSyncType </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-16:33
 */
@Slf4j
@Component
public abstract class AbstractDataSyncType implements EventTypeAction {

    private static final boolean RUNNING_STATUS = true;

    private final CanalConnector canalConnector;
    private final CanalProperties canalProperties;

    @Autowired
    public AbstractDataSyncType(@Qualifier("canalConnector") CanalConnector canalConnector,
                                @Qualifier("canalProperties") CanalProperties canalProperties) {
        this.canalConnector = canalConnector;
        this.canalProperties = canalProperties;
    }

    public void run() {
        while (RUNNING_STATUS) {
            log.info("canal begin to run");
            Message message = canalConnector.getWithoutAck(canalProperties.getBatchSize());
            long batchId = message.getId();
            int size = message.getEntries().size();
            if (!(batchId == -1 || size == 0)) {
                log.info("begin to process which batchId is : " + batchId);
                List<EventHandlerContext> handlers = createHandlers(createEventInfo(message.getEntries()));
                if (handlers != null) {
                    for (EventHandlerContext handler : handlers) {
                        // 同步处理, 处理完后ack(也可以放在一个Queue里按个顺序ack, 处理耗时不大,场景适合,如遇到处理耗时多的场景, 可以考虑放入MQ队列里,削峰消费处理,)
                        // 放到线程池异步处理时, 可能会出现CanalClientException: deserializer failed, ack error , clientId:1001 batchId:680 is not exist , please check
                        // 出现的原因是异步处理, 可能先提交了大的batchId, 导致另一个batchId小的
                        // 线程处理完回来ack的时候, 发现batchId不存在了,因为被大的batchId覆盖了
                        try {
                            handler.handler();
                        } catch (Exception e) {
                            log.error("process batchId is " + batchId + " error, the exception message is : " + e.getMessage(), e);
                            canalConnector.rollback();
                        }
                        // 处理完一个批次的数据,再ack
                        canalConnector.ack(batchId);
                    }
                }
            }
        }
    }

    /**
     * 产生事件信息和数据
     *
     * @param entries List<CanalEntry.Entry>
     * @return List<EventInfo>
     */
    private List<EventInfo> createEventInfo(List<CanalEntry.Entry> entries) {
        // 事件信息集合
        List<EventInfo> eventInfoList = new ArrayList<>(entries.size());
        for (CanalEntry.Entry entry : entries) {
            /**
             * 开启/关闭事务的实体类型，跳过
             */
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            // RowChange对象，包含了一行数据变化的所有特征
            // 比如isDdl 是否是ddl变更操作 sql 具体的ddl sql beforeColumns afterColumns 变更前后的数据字段等等
            CanalEntry.RowChange rowChange = null;
            try {
                rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 获取操作类型：insert/update/delete类型
            CanalEntry.EventType eventType = rowChange.getEventType();
            // 数据库
            String schemaName = entry.getHeader().getSchemaName();
            // 表名
            String tableName = entry.getHeader().getTableName();
            log.info("=========binlog[{} : {}], tableName[{} : {}], eventTYPE : {}",
                    entry.getHeader().getLogfileName(),
                    entry.getHeader().getLogfileOffset(),
                    schemaName,
                    tableName,
                    eventType);
            for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
                eventInfoList.add(new EventInfo(rowData, eventType, tableName, schemaName));
            }
        }
        return eventInfoList;
    }

    /**
     * @param eventInfo List<EventInfo>
     * @return List<EventHandlerContext>
     */
    private List<EventHandlerContext> createHandlers(List<EventInfo> eventInfo) {
        if (eventInfo == null || eventInfo.size() == 0) {
            log.info("-----------------no event so no need to process any thing-----------------");
            return Collections.emptyList();
        }
        // 事件处理集合
        List<EventHandlerContext> eventHandlerList = new ArrayList<>(eventInfo.size());
        for (EventInfo info : eventInfo) {
            IEventHandler eventHandler = createEventHandlerByEventType(info);
            if (eventHandler != null) {
                eventHandlerList.add(new EventHandlerContext(eventHandler, info));
            }
        }
        return eventHandlerList;
    }

    /**
     * create event handler by event type
     *
     * @param eventInfo List<EventInfo>
     * @return IEventHandler
     */
    @Override
    public abstract IEventHandler createEventHandlerByEventType(EventInfo eventInfo);
}
