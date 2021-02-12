import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 0:29
 */
@SpringJUnitConfig(locations = {"classpath:spring/spring.xml"})
public class TestDrivenDevelopment {

    private static final String HELLO_WORLD = "World";

    @Autowired
    @Qualifier(value = "kapcb")
    private User kapcb;

    @Autowired
    private IUserService userService;

    @Test
    public void testSpringJunitConfigByXml() {
        System.out.println("kapcb = " + kapcb);
    }

    @Test
    public void testSpringJunitConfig() {
        userService.testSpringJunitConfig(HELLO_WORLD);
    }
}
