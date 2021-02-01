import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 21:28
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";
    private static final String FILE_SYSTEM_CONTEXT_CONFIG_LOCATION = "D:/DevelopTools/IDEA/IDEA-workspace/Spring-Kapcb/[003]Spring-IOC-ApplicationContext/src/main/resources/spring/spring.xml";
    private static final String USER_SERVICE_BEAN_ID = "userService";

    /**
     * ClassPathXmlApplicationContext(String) 加载类路径下的 contextConfigLocation 配置文件
     */
    @Test
    public void testApplicationContext() {
        System.out.println("begin to load context config...");
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        IUserService bean = ioc.getBean(USER_SERVICE_BEAN_ID, IUserServiceImpl.class);
        User kapcb = bean.getUserByUsername("kapcb");
        System.out.println("kapcb = " + kapcb);
    }

    /**
     * FileSystemXmlApplicationContext(String) 加载盘符路径下的 contextConfigLocation 配置文件
     */
    @Test
    public void testFileSystemXmlApplicationContext() {
        ApplicationContext ioc = new FileSystemXmlApplicationContext(FILE_SYSTEM_CONTEXT_CONFIG_LOCATION);
        IUserServiceImpl bean = ioc.getBean(USER_SERVICE_BEAN_ID, IUserServiceImpl.class);
        User kapcb = bean.getUserByUsername("kapcb");
        System.out.println("kapcb = " + kapcb);
    }
}
