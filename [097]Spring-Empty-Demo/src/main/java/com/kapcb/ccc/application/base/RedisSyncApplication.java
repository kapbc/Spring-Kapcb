import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <a>Title: RedisSyncApplication </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-17:05
 */
@Slf4j
public class RedisSyncApplication extends AbstractDataSyncType {

    private final EventHandlerFactory eventHandlerFactory;
    private final CanalProperties canalProperties;

    @Autowired
    public RedisSyncApplication(@Qualifier("canalConnector") CanalConnector canalConnector,
                                @Qualifier("canalProperties") CanalProperties canalProperties,
                                @Qualifier("eventHandlerFactory") EventHandlerFactory eventHandlerFactory) {
        super(canalConnector, canalProperties);
        this.eventHandlerFactory = eventHandlerFactory;
        this.canalProperties = canalProperties;
    }

    @Override
    public IEventHandler createEventHandlerByEventType(EventInfo eventInfo) {
        log.info("the custom is : " + canalProperties.getCustom());
        if (canalProperties.getCustom()) {
            // 自定义的表处理 , 即不同表有不同的处理逻辑, 也有可能共用一个处理逻辑
            return eventHandlerFactory.getEventHandler(eventInfo.getUnionKey());
        } else {
            // 全局的处理
            return eventHandlerFactory.getEventHandler(EventHandlerFactory.createUnionKey(eventInfo.getEventType()));
        }
    }
}
