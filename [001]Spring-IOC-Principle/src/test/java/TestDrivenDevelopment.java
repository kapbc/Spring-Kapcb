import com.kapcb.ccc.domian.User;
import com.kapcb.ccc.factory.InstanceFactory;
import com.kapcb.ccc.factory.PromotionInstanceFactory;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IUserServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 11:33
 */
public class TestDrivenDevelopment {

    private static final String PROPERTIES_RESOURCE_PATH = "properties/system.properties";
    private static final String CLASS_PATH_FROM_PROPERTIES_KEY = "service.class.path";

    /**
     * load the class path from properties resources file
     * {@link InstanceFactory#getUserService(String)}
     */
    @Test
    public void testInstanceFactory() {
        System.out.println("test the instance factory...");
        Properties properties = new Properties();
        ClassLoader classLoader = TestDrivenDevelopment.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(PROPERTIES_RESOURCE_PATH)) {
            properties.load(inputStream);
            String clazzPath = properties.getProperty(CLASS_PATH_FROM_PROPERTIES_KEY);
            IUserService userService = InstanceFactory.getUserService(clazzPath);
            List<User> userInfo = userService.getUserInfo();
            userInfo.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get the instance by class
     * {@link PromotionInstanceFactory#getUserService(Class)}
     */
    @Test
    public void testPromotionInstanceFactory() {
        System.out.println("test the promotion instance factory...");
        IUserService userService = PromotionInstanceFactory.getUserService(IUserServiceImpl.class);
        List<User> userInfo = userService.getUserInfo();
        userInfo.forEach(System.out::println);
    }
}
