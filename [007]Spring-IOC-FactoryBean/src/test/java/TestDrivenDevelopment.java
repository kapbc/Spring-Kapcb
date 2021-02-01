import com.kapcb.ccc.domian.AirPlane;
import com.kapcb.ccc.factory.AirPlaneInstanceFactory;
import com.kapcb.ccc.factory.AirPlaneStaticInstanceFactory;
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
 * @date 2021/1/31 11:59
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    /**
     * 测试FactoryBean
     */
    @Test
    public void testFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        AirPlaneInstanceFactory airPlaneInstanceFactory = ioc.getBean("airPlaneInstanceFactory", AirPlaneInstanceFactory.class);
        System.out.println("airPlaneInstanceFactory = " + airPlaneInstanceFactory + "\n\n");
    }

    @Test
    public void testAirPlaneFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        AirPlane airPlaneFactoryBean = ioc.getBean("airPlaneFactoryBean", AirPlane.class);
        AirPlane airPlaneFactoryBeanTwo = ioc.getBean("airPlaneFactoryBean", AirPlane.class);
        System.out.println(airPlaneFactoryBean == airPlaneFactoryBeanTwo);
    }

    @Test
    public void testInstanceFactoryAndStaticBeanFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        AirPlaneInstanceFactory airPlaneInstanceFactory = ioc.getBean("airPlaneInstanceFactory", AirPlaneInstanceFactory.class);
        AirPlane airPlane747 = airPlaneInstanceFactory.getAirPlane("747");
        System.out.println("instance air create plane : " + airPlane747);

        AirPlane airPlane757 = AirPlaneStaticInstanceFactory.getAirPlane("757");
        System.out.println("static instance air create plane : " + airPlane757);
    }
}
