/**
 * <a>Title: EventTypeAction </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-16:31
 */
public interface EventTypeAction {

    /**
     * creat event handler by event type
     *
     * @param eventInfo EventInfo
     * @return IEventHandler
     */
    IEventHandler createEventHandlerByEventType(EventInfo eventInfo);
}
