import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 14:03
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    /**
     * 按照类型获取组件，可以获取到这个类型下的所有实现类子类等
     */
    @Test
    public void testSingletonDataSource() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        DataSource bean = ioc.getBean(DataSource.class);
        try {
            System.out.println("bean.getConnection() = " + bean.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
