import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 10:31
 */
@SpringJUnitConfig(locations = {"classpath:spring/spring.xml"})
public class TestDrivenDevelopment {

    private static final Logger log = LoggerFactory.getLogger(TestDrivenDevelopment.class);

    @Value("${system.properties.kapcb.nb}")
    private String systemProperties;

    @Value(value = "${spring.annotation.value.test}")
    private String kapcbProperties;

    @Value(value = "#{propertiesFactoryBean['spring.annotation.configuration.username']}")
    private String kapcbPropertiesUsername;

    @Value(value = "#{propertiesFactoryBean['system.properties.kapcb.must.nb']}")
    private String systemPropertiesNb;

    @Test
    public void testAnnotationValue() {
        log.warn("begin to get properties from ioc context....");
        System.out.println("systemProperties = " + systemProperties);
        System.out.println("kapcbProperties = " + kapcbProperties);
        log.warn("process get properties from ioc context success...");
    }

    @Test
    public void testAnnotationValuePropertiesFactoryBean() {
        log.warn("begin to get properties from ioc context...");
        System.out.println("kapcbPropertiesUsername = " + kapcbPropertiesUsername);
        System.out.println("systemPropertiesNb = " + systemPropertiesNb);
        log.warn("process get properties from ioc context success...");
    }
}
