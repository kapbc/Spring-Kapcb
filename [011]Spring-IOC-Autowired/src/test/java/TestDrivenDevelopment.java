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
 * @date 2021/1/31 21:12
 */
public class TestDrivenDevelopment {

    private static final String context_config_location = "classpath:spring/spring.xml";

    @Test
    public void testManualJNDIProperties() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(context_config_location);
        User manual = ioc.getBean("manual", User.class);
        System.out.println("manual = " + manual);
    }

    /**
     * 在Spring的配置文件中, 并没有为auto这个Bean实例设置car属性
     * 但是在输出的时候car属性却是已经被注入了的
     * 因为配置的 autowired = ”byName“后, Spring会根据bean的名称去ioc容器中
     * 查找是否存在与这个名称对应的Bean, 如果存在则会自动将其使用set方法为Bean注入属性值
     * 而在Spring的配置文件中刚好配置了Bean名称为car的实例, 所以Spring会将这个Bean自动注入
     * 到auto这个Bean的car属性中
     */
    @Test
    public void testAutoJNDIProperties() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(context_config_location);
        User auto = ioc.getBean("auto", User.class);
        System.out.println("auto = " + auto);
    }
}
