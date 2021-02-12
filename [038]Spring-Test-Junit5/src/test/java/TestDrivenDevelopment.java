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
 * 下面的注解还可以使用SpringJunitConfig一个注解代替完成
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 23:26
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class TestDrivenDevelopment {

    /**
     * Spring5 整合 Junit5 所需的依赖
     *         <!-- Spring-Test-Junit Begin -->
     *         <dependency>
     *             <groupId>org.springframework</groupId>
     *             <artifactId>spring-test</artifactId>
     *             <version>${spring.version}</version>
     *         </dependency>
     *         <!-- junit5 Begin -->
     *         <dependency>
     *             <groupId>org.junit.jupiter</groupId>
     *             <artifactId>junit-jupiter-api</artifactId>
     *             <version>${junit5.version}</version>
     *             <scope>test</scope>
     *         </dependency>
     *         <!-- junit5 End -->
     *         <!-- Spring-Test-Junit End -->
     */
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
