import com.alibaba.otter.canal.protocol.CanalEntry;

/**
 * <a>Title: EventInfo </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-15:19
 */
public class EventInfo {

    /**
     * 行数据
     */
    private CanalEntry.RowData rowData;

    /**
     * 数据库信息
     */
    private TableInfo tableInfo;

    /**
     * MySQL事件类型
     */
    private CanalEntry.EventType eventType;

    public EventInfo(CanalEntry.RowData rowData, CanalEntry.EventType eventType, String databaseName, String tableName) {
        this.rowData = rowData;
        this.eventType = eventType;
        this.tableInfo = new TableInfo(databaseName, tableName);
    }

    public CanalEntry.RowData getRowData() {
        return this.rowData;
    }

    public CanalEntry.EventType getEventType() {
        return this.eventType;
    }

    /**
     * 数据库+表名+mysql里事件类型 组合成一个唯一的key, 可以对应为一个EventHandler
     *
     * @return String
     */
    public String getUnionKey() {
        return EventHandlerFactory.createUnionKey(this.tableInfo, this.eventType);
    }
}
