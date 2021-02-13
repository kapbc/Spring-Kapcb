import com.kapcb.ccc.commons.config.SpringContextConfiguration;
import com.kapcb.ccc.domain.KpacbDataSource;
import com.kapcb.ccc.domain.SystemProperties;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 20:39
 */
@SpringJUnitConfig(classes = {SpringContextConfiguration.class})
public class TestDrivenDevelopment {

    private static final Logger log = LoggerFactory.getLogger(TestDrivenDevelopment.class);

    @Autowired
    private SystemProperties systemProperties;

    @Autowired
    private KpacbDataSource kpacbDataSource;

    @Test
    public void testAnnotationApplicationPropertyConfiguration() {
        log.warn("begin to test annotation application property configuration....");
        String username = systemProperties.getUsername();
        System.out.println("username = " + username);
        String password = systemProperties.getPassword();
        System.out.println("password = " + password);
        log.warn("process annotation property success...");
    }

    @Test
    public void testAnnotationApplicationPropertyConfigurationFromIOC() {
        log.warn("begin to test the properties from ioc....");
        System.out.println("kpacbDataSource = " + kpacbDataSource);
        log.warn("process success...");
    }
}
