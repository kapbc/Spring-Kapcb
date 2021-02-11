import com.kapcb.ccc.commons.config.ContextConfiguration;
import com.kapcb.ccc.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 13:25
 */
public class TestDrivenDevelopment {

    @Test
    public void testDataTransaction() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        IAccountService accountService = ioc.getBean("accountService", IAccountService.class);
        boolean b = accountService.transferBalance("0001", "mike", BigDecimal.valueOf(10000), "0002", "kapcb");
        System.out.println("b = " + b);
    }
}
