import com.alibaba.otter.canal.protocol.CanalEntry;
import com.globalsources.cannal.service.IEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <a>Title: IEventUpdateHandler </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-13:24
 */
@Slf4j
@Component("iEventUpdateHandler")
public class IEventUpdateHandler implements IEventHandler {
    @Override
    public void handler(CanalEntry.RowData rowData) {

    }
}
