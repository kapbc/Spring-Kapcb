import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.proxy.UserLoginProxy;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IUserServiceImpl;
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
 * @date 2021/2/5 22:24
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    @Test
    public void testJDKDynamicAutoProxy() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        IUserService userService = ioc.getBean("userService", IUserServiceImpl.class);
        IUserService proxy = UserLoginProxy.getProxy(userService);
        User kapcb = proxy.login("kapcb", "123456");
        System.out.println("kapcb = " + kapcb + "\n\n");

        System.out.println(userService == proxy);
        System.out.println("userService = " + userService.getClass());
        System.out.println("proxy = " + proxy.getClass());
    }
}
