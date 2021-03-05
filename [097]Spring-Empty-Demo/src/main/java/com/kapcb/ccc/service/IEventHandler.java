import com.alibaba.otter.canal.protocol.CanalEntry;

/**
 * <a>Title: IEventHandler </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-13:22
 */
public interface IEventHandler {

    void handler(CanalEntry.RowData rowData);
}
