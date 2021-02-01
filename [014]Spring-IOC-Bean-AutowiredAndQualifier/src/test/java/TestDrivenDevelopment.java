import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IUserServiceAutowiredImpl;
import com.kapcb.ccc.service.impl.IUserServiceQualifierImpl;
import com.kapcb.ccc.service.impl.IUserServiceResourceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 21:20
 */
public class TestDrivenDevelopment {

    private static final String BASE_PACKAGES = "com.kapcb.ccc";

    @Test
    public void testAutowiredByType() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(BASE_PACKAGES);
        IUserService userService = ioc.getBean("userServiceAutowired", IUserServiceAutowiredImpl.class);
        List<User> userInfo = userService.getUserInfo();
        userInfo.forEach(System.out::println);
    }

    @Test
    public void testQualifierByAttributeName() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(BASE_PACKAGES);
        IUserService userServiceQualifier = ioc.getBean("userServiceQualifier", IUserServiceQualifierImpl.class);
        List<User> userInfo = userServiceQualifier.getUserInfo();
        userInfo.forEach(System.out::println);
    }

    @Test
    public void testResourceByName() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(BASE_PACKAGES);
        IUserService userServiceResource = ioc.getBean("userServiceResource", IUserServiceResourceImpl.class);
        List<User> userInfo = userServiceResource.getUserInfo();
        userInfo.forEach(System.out::println);
    }
}
