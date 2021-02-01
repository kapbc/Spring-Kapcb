import com.kapcb.ccc.domain.Car;
import com.kapcb.ccc.domain.User;
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
 * @date 2021/1/30 23:42
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";
    private static final String SYSTEM_FILE_CONTEXT_CONFIG_LOCATION = "D:/DevelopTools/IDEA/IDEA-workspace/Spring-Kapcb/[006]Spring-IOC-Bean-Complex/src/main/resources/spring/spring.xml";

    @Test
    public void testSimpleBeanCar() {
        ApplicationContext ioc = new FileSystemXmlApplicationContext(SYSTEM_FILE_CONTEXT_CONFIG_LOCATION);
        Car car = ioc.getBean("car", Car.class);
        System.out.println("the car is : " + car + "\n\n");
    }

    @Test
    public void testCDATATags() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        Car pagani = ioc.getBean("pagani", Car.class);
        System.out.println("pagani : " + pagani);
    }

    @Test
    public void testSpELBeanJNDI() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User user = ioc.getBean("user", User.class);
        System.out.println("the user with SpEL is : " + user);
    }

    /**
     * 默认不赋值就为 null
     */
    @Test
    public void testSimpleBeanUser() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User kapcb = ioc.getBean("kapcb", User.class);
        System.out.println("the user info is : " + kapcb + "\n\n");
    }

    @Test
    public void testListBeanUser() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User ccc = ioc.getBean("ccc", User.class);
        System.out.println("ccc = " + ccc);
    }

    @Test
    public void testMapBeanUser() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User mike = ioc.getBean("mike", User.class);
        System.out.println("==============test map bean==============");
        mike.getHouses().forEach((k, v) -> {
            System.out.println("key is : " + k + ", value is : " + v);
        });
        System.out.println("==============test map bean==============");
    }

    @Test
    public void testPropertiesBeanUser() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User chen = ioc.getBean("chen", User.class);
        System.out.println("==============test properties bean==============");
        chen.getProperties().forEach((k, v) -> {
            System.out.println("key is : " + k + ", value is : " + v);
        });
        System.out.println("==============test properties bean==============");
    }

    @Test
    public void testUtilBeanUser() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User bossChen = ioc.getBean("bossChen", User.class);
        System.out.println("==============test util bean==============");
        bossChen.getHouses().forEach((k, v) -> {
            System.out.println("key is : " + k + ", value is : " + v);
        });
        System.out.println("==============test util bean==============");
    }

    @Test
    public void testCascadeAttributeModificationBeanUser() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User bossKapcb = ioc.getBean("bossKapcb", User.class);
        Car drivenCar = bossKapcb.getDrivenCar();
        System.out.println("==============test cascade attribute modification==============");
        System.out.println("boss chen's driven car is : " + drivenCar);

        Car car = ioc.getBean("car", Car.class);
        System.out.println("car = " + car);
        System.out.println("==============test cascade attribute modification==============");
    }

    @Test
    public void testAbstractParentBeanUser() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        User bossMike = ioc.getBean("bossMike", User.class);
        System.out.println("==============test cascade attribute modification==============");
        System.out.println("the boss info is : " + bossMike);
    }
}
