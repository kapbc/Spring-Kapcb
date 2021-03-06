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
@Slf4j
@Component("iEventDeleteHandler")
public class IEventDeleteHandler implements IEventHandler {

    private final RedisHandler redisHandler;

    @Autowired
    public IEventDeleteHandler(@Qualifier("redisHandler") RedisHandler redisHandler) {
        this.redisHandler = redisHandler;
    }

    @Override
    public void handler(CanalEntry.RowData rowData) {
        String key = "";
        redisHandler.delete(rowData, key);
    }
}
