import com.kapcb.ccc.service.IAccountService;
import com.kapcb.ccc.service.impl.IAccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7 22:46
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    @Test
    public void DataTransaction() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        IAccountService accountService = ioc.getBean("accountService", IAccountServiceImpl.class);
        boolean b = accountService.transferOutFromAccount();
        System.out.println("b = " + b);
        boolean b1 = accountService.transferInFromAccount();
        System.out.println("b1 = " + b1);
    }
}
