import com.kapcb.ccc.commons.config.ContextConfigurationForNest;
import com.kapcb.ccc.commons.config.ContextConfigurationForXml;
import com.kapcb.ccc.domain.DataSource;
import com.kapcb.ccc.domain.Person;
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
@ContextConfiguration(classes = {com.kapcb.ccc.commons.config.ContextConfiguration.class, ContextConfigurationForNest.class, ContextConfigurationForXml.class})
public class TestDrivenDevelopment {

    @Autowired
    @Qualifier(value = "kapcb")
    private User kapcb;

    @Autowired
    @Qualifier(value = "kapcbDataSource")
    private DataSource kapcbDataSource;

    @Autowired
    @Qualifier(value = "kapcbPerson")
    private Person kapcbPerson;

    /**
     * com.kapcb.ccc.commons.config.ContextConfiguration.class
     * 需要导入配置类到Junit5的配置文件中才能正常获取到Spring中的Bean实例
     */
    @Test
    public void testSpringAnnotationConfiguration() {
        System.out.println("kapcb = " + kapcb);
    }


    /**
     * ContextConfigurationForNest.class
     * 需要导入配置类到Junit5的配置文件中才能正常获取到Spring中的Bean实例
     */
    @Test
    public void testSpringAnnotationConfigurationForNest() {
        System.out.println("kapcbDataSource = " + kapcbDataSource);
    }

    /**
     * ContextConfigurationForXml.class
     * 需要导入配置类到Junit5的配置文件中才能正常获取到Spring中的Bean实例
     */
    @Test
    public void testSpringAnnotationConfigurationForXml() {
        System.out.println("kapcbPerson = " + kapcbPerson);
    }
}