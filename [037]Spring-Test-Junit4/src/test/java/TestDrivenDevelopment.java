import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 23:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestDrivenDevelopment {

    private static final String HELLO_WORLD = "World";

    /**
     * 直接注入Spring.xml中配置完成的Bean即可
     */
    @Autowired
    @Qualifier(value = "kapcb")
    private User kapcb;

    @Autowired
    private IUserService userService;

    /**
     * RunWith(SpringJUnit4ClassRunner.class)
     * 用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，为了便于使用spring的依赖注入，
     * spring提供了org.springframework.test.context.junit4.SpringJUnit4ClassRunner作为Junit测试环境
     * <p>
     * ContextConfiguration(locations = {"classpath:spring/spring.xml"})
     * 指定配置文件的位置，多个配置文件逗号隔开即可
     */
    @Test
    public void testSpringJunit4ClassRunner() {
        System.out.println("kapcb = " + kapcb);
    }

    @Test
    public void testSpringJunit4ClassRunnerWithComponent() {
        userService.testSpringJunit4ClassRunner(HELLO_WORLD);
    }
}
