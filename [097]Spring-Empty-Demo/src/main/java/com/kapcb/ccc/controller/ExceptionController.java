import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <a>Title: ExceptionController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-11:45
 */
@RestControllerAdvice
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler
    public String handlerSystemException(Exception e) {
        e.printStackTrace();
        log.error("System process error, the exception message is : " + e.getMessage());
        return new JsonBuilder()
                .put("message", "system error")
                .put("code", "201")
                .put("data", null)
                .builder();
    }
}
