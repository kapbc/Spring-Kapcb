import com.kapcb.ccc.configs.ContextConfiguration;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IUserServiceImpl;
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
 * @date 2021/2/1 22:36
 */
public class TestDrivenDevelopment {

    @Test
    public void testAnnotationConfiguration() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        //ApplicationContext ioc = new AnnotationConfigApplicationContext("com.kapcb.ccc");
        IUserService userService = ioc.getBean("userService", IUserServiceImpl.class);
        User user = userService.getUserInfo();
        System.out.println("user = " + user);
    }
}
