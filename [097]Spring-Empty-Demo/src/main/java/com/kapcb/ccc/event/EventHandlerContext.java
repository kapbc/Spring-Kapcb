import com.globalsources.cannal.service.IEventHandler;

/**
 * <a>Title: EventHandlerContext </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-15:17
 */
public class EventHandlerContext {

    private IEventHandler eventHandler;

    private EventInfo eventInfo;

    public EventHandlerContext(IEventHandler eventHandler, EventInfo eventInfo) {
        this.eventInfo = eventInfo;
        this.eventHandler = eventHandler;
    }

    public void setEventHandler(IEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void handler() {
        this.eventHandler.handler(eventInfo.getRowData());
    }
}
