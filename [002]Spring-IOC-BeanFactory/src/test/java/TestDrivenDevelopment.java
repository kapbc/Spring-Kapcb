import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IUserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 21:04
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";
    private static final String USER_SERVICE_BEAN_ID = "userService";
    private static final String USER_NAME = "kapcb";

    /**
     * 使用BeanFactory接口创建IOC, 在加载配置文件的时候并不会创建配置文件中的对象,
     * 而是在调用的时候创建
     * <p>
     * 在实际开发中, 从创建资源的角度来讲, 在第一使用的时候才去创建对象会显得比较节约资源
     * 但是在实际开发中, 能够在启动时候创建的资源应该尽量都在项目启动时就创建, 启动总是需
     * 要时间的, 启动时间久了相对而言更为适合
     */
    @Test
    public void testBeanFactory() {
        System.out.println("begin to load the context config....\n\n");
        BeanFactory ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User ccc = new User(11111L, "N", "ccc", "1234", LocalDateTime.now());
        System.out.println(ccc + "\n\n");
        System.out.println("begin to get bean from spring ioc context....");
        IUserService bean = ioc.getBean(USER_SERVICE_BEAN_ID, IUserServiceImpl.class);
        System.out.println("begin to transfer the method in IUserServiceImpl...\n\n");
        User user = bean.getUserByUsername(USER_NAME);
        System.out.println("Hello I am " + user.getUsername() + " from the spring context.....");
    }
}
