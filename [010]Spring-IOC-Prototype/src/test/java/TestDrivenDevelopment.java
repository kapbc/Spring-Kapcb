import com.kapcb.ccc.domain.User;
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
 * @date 2021/1/31 20:34
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    @Test
    public void testSingleton() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User userSingletonOne = ioc.getBean("userSingleton", User.class);
        User userSingletonTwo = ioc.getBean("userSingleton", User.class);
        System.out.println(userSingletonOne == userSingletonTwo);
    }

    @Test
    public void testPrototype() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User userPrototypeOne = ioc.getBean("userPrototype", User.class);
        User userPrototypeTwo = ioc.getBean("userPrototype", User.class);
        System.out.println(userPrototypeOne == userPrototypeTwo);
    }
}
