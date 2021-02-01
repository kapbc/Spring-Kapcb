import com.kapcb.ccc.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 23:04
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";
    private static final String CCC_BEAN_ID = "ccc";
    private static final String KAPCB_BEAN_ID = "kapcb";
    private static final String ERIC_BEAN_ID = "eric";

    @Test
    public void testDIBySet() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User user = ioc.getBean(CCC_BEAN_ID, User.class);
        System.out.println("user = " + user);
    }

    @Test
    public void testDIByAllArgsConstructor() {
        BeanFactory ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User bean = ioc.getBean(KAPCB_BEAN_ID, User.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void testDIByAllArgsConstructorWithoutName() {
        BeanFactory ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User bean = ioc.getBean(ERIC_BEAN_ID, User.class);
        System.out.println("bean = " + bean);
    }
}
