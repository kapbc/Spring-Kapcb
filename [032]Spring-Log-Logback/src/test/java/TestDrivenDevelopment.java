import com.kapcb.ccc.service.ILogService;
import com.kapcb.ccc.service.impl.ILogServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 13:50
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    @Test
    public void testTheLog4j2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        ILogService logService = ioc.getBean("logService", ILogServiceImpl.class);
        boolean kapcb = logService.login("kapcb", "123456");
        System.out.println("kapcb = " + kapcb);
    }
}
