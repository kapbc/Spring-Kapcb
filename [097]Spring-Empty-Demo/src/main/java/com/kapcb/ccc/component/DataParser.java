import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a>Title: DataParser </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-17:36
 */
@Slf4j
public class DataParser {

    private DataParser(){}

    private static final int INITIAL_CAPACITY = 16;

    public static Map<String, String> parse(CanalEntry.RowData rowData, boolean after) {
        List<CanalEntry.Column> columnsList;
        if (after) {
            // 修改后的列, 如修改,新增
            log.info("the column after change");
            columnsList = rowData.getAfterColumnsList();
        } else {
            // false为修改前的列, 如删除
            log.info("the column before change");
            columnsList = rowData.getBeforeColumnsList();
        }
        Map<String, String> dataMap = new HashMap<>(INITIAL_CAPACITY);
        columnsList.forEach(s -> {
            dataMap.put(s.getName(), s.getValue());
        });
        return dataMap;
    }
}
