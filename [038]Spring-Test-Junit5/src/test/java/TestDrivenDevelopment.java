import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 23:26
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestDrivenDevelopment {

    private static final String HELLO_WORLD = "World";

    @Autowired
    @Qualifier(value = "kapcb")
    private User kapcb;


    @Autowired
    private IUserService userService;

    /**
     * org.junit.jupiter.api.Test;
     * org.junit.jupiter.api.extension.ExtendWith;
     * <p>
     * ExtendWith(SpringExtension.class) 指定Spring5整合的Junit5进行测试
     * Test 使用Junit5的Test注解
     */
    @Test
    public void testSpringExtendJunit5() {
        System.out.println("==============================================");
        System.out.println("kapcb = " + kapcb);
        System.out.println("==============================================");
    }

    @Test
    public void testSpringExtendJunit5ByComponent() {
        userService.testSpringExtension(HELLO_WORLD);
    }
}
