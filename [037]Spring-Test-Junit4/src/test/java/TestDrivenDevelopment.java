import org.junit.Test;
import org.junit.runner.RunWith;
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

    /**
     *
     * RunWith(SpringJUnit4ClassRunner.class)
     * 用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，为了便于使用spring的依赖注入，
     * spring提供了org.springframework.test.context.junit4.SpringJUnit4ClassRunner作为Junit测试环境
     */
    @Test
    public void testSpringJunit4ClassRunner(){

    }
}
