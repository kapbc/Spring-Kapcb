import lombok.Getter;

/**
 * <a>Title: TableInfo </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-15:19
 */
@Getter
public class TableInfo {

    /**
     * 数据库名称
     */
    private String databaseName;

    /**
     * 表名
     */
    private String tableName;

    public TableInfo(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
    }
}
