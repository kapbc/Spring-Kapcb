import com.alibaba.otter.canal.protocol.CanalEntry;
import com.globalsources.cannal.service.IEventHandler;
import org.springframework.stereotype.Component;

/**
 * <a>Title: IEventDeleteHandler </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-13:23
 */
@Component("iEventDeleteHandler")
public class IEventDeleteHandler implements IEventHandler {
    @Override
    public void handler(CanalEntry.RowData rowData) {

    }
}
