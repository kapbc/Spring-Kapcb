import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/6 16:42
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    /**
     * 测试数据库配置是否能正常连接到数据库
     */
    @Test
    public void testDatSource() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println("dataSource's class is: " + dataSource.getClass());
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        IUserService userService = ioc.getBean("userService", IUserServiceImpl.class);
        List<User> userInfoList = userService.getUserInfoList();
        userInfoList.forEach(System.out::println);
    }

    @Test
    public void testJdbcTemplateInset() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        IUserService userService = ioc.getBean("userService", IUserServiceImpl.class);
        User user = new User();
        user.setUserId(11111111L);
        user.setUsername("ccc");
        user.setPassword("123456");
        user.setPhone("123456789");
        user.setEmail("eircccalroot@163.com");
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        System.out.println(userService.insertUser(user));
    }
}