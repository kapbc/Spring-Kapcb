import com.kapcb.ccc.commons.config.ContextConfigurationForNest;
import com.kapcb.ccc.domain.DataSource;
import com.kapcb.ccc.domain.User;
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
 * @date 2021/2/13 9:55
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {com.kapcb.ccc.commons.config.ContextConfiguration.class, ContextConfigurationForNest.class})
public class TestDrivenDevelopment {

    @Autowired
    @Qualifier(value = "kapcb")
    private User kapcb;

    @Autowired
    @Qualifier(value = "kapcbDataSource")
    private DataSource kapcbDataSource;

    @Test
    public void testSpringAnnotationConfiguration() {
        System.out.println("kapcb = " + kapcb);
    }


    @Test
    public void testSpringAnnotationConfigurationForNest() {
        System.out.println("kapcbDataSource = " + kapcbDataSource);
    }
}