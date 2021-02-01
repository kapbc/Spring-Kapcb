import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 22:20
 */
public class TestDrivenDevelopment {

    private static final String BASE_PACKAGE = "com.kapcb.ccc";

    @Test
    public void testAnnotationConfigurationBean() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        User user = ioc.getBean("user", User.class);
        System.out.println("user = " + user);
    }

    @Test
    public void testAnnotationConfigurationService() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        UserServiceImpl userService = ioc.getBean("userService", UserServiceImpl.class);
        userService.transfer();
    }
}
