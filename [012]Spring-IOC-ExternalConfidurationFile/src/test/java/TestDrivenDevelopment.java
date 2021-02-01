import com.kapcb.ccc.config.DataSource;
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
 * @date 2021/1/31 21:49
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    @Test
    public void testExternalConfigurationFile() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println("dataSource = " + dataSource);
    }
    
    @Test
    public void testAutowired(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User user = ioc.getBean("user", User.class);
        System.out.println("user = " + user);
    }
}
