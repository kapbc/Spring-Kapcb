import com.alibaba.otter.canal.protocol.CanalEntry;
import com.globalsources.cannal.event.EventHandlerFactory;
import com.globalsources.cannal.event.TableInfo;
import com.globalsources.cannal.service.impl.IEventInsertHandler;
import com.globalsources.cannal.service.impl.IEventDeleteHandler;
import com.globalsources.cannal.service.impl.IEventUpdateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: EventHandlerFactoryConfig </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-15:37
 */
@Slf4j
@Configuration
public class EventHandlerFactoryConfig {

    private final CanalProperties canalProperties;
    private final IEventInsertHandler iEventInsertHandler;
    private final IEventDeleteHandler iEventDeleteHandler;
    private final IEventUpdateHandler iEventUpdateHandler;

    @Autowired
    public EventHandlerFactoryConfig(IEventInsertHandler iEventAddHandler, IEventDeleteHandler iEventDeleteHandler,
                                     IEventUpdateHandler iEventUpdateHandler, CanalProperties canalProperties) {
        this.canalProperties = canalProperties;
        this.iEventInsertHandler = iEventAddHandler;
        this.iEventDeleteHandler = iEventDeleteHandler;
        this.iEventUpdateHandler = iEventUpdateHandler;
    }

    public EventHandlerFactory register() {
        log.info("begin to register eventHandlerFactory into spring application context");
        EventHandlerFactory eventHandlerFactory = new EventHandlerFactory();
        Boolean custom = canalProperties.getCustom();
        if (custom) {
            // 多过滤器分隔
            String[] filterSplit = canalProperties.getFilter().split(CanalConstants.DEFAULT_FILTER_SPLIT);
            List<String> filterList = new ArrayList<>(Arrays.asList(filterSplit));
            //表信息
            List<TableInfo> tableInfoList = new ArrayList<>(filterList.size());
            if (!Objects.equals(null, filterList)) {
                for (String filter : filterList) {
                    String[] split = filter.split(CanalConstants.DEFAULT_TABLE_SPLIT);
                    if (split.length > 1) {
                        tableInfoList.add(new TableInfo(split[0], split[1]));
                    } else {
                        log.error("canal read filter error");
                        throw new RuntimeException("canal read filter error");
                    }
                }
            }

            // 为每个数据库不同的表添加业务处理逻辑
            for (TableInfo tableInfo : tableInfoList) {
                eventHandlerFactory.setEventHandler(EventHandlerFactory.createUnionKey(tableInfo, CanalEntry.EventType.DELETE), iEventDeleteHandler);
                eventHandlerFactory.setEventHandler(EventHandlerFactory.createUnionKey(tableInfo, CanalEntry.EventType.INSERT), iEventInsertHandler);
                eventHandlerFactory.setEventHandler(EventHandlerFactory.createUnionKey(tableInfo, CanalEntry.EventType.UPDATE), iEventUpdateHandler);
            }
        }else {

        }
        return eventHandlerFactory;
    }
}
