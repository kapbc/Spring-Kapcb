import com.kapcb.ccc.proxy.CalculatorProxy;
import com.kapcb.ccc.service.ICalculatorService;
import com.kapcb.ccc.service.impl.ICalculatorServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 23:06
 */
public class TestDrivenDevelopment {

    private static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/spring.xml";

    @Test
    public void testJDKDynamicAutoProxy() {
        ICalculatorService iCalculatorService = new ICalculatorServiceImpl();
        int add = iCalculatorService.add(1, 2);
        System.out.println("add = " + add);

        /**
         * 拿到这个对象的代理对象，代理对象执行 加减乘除
         */
        ICalculatorService proxy = CalculatorProxy.getProxy(iCalculatorService);
        int div = proxy.div(3, 2);
        System.out.println("div = " + div);

        System.out.println("proxy.getClass() = " + proxy.getClass());
        System.out.println("iCalculatorService.getClass() = " + iCalculatorService.getClass());
        System.out.println(proxy.getClass() == iCalculatorService.getClass());

        /**
         * 代理对象实例
         */
        List<Class<?>> classes = Arrays.asList(proxy.getClass().getInterfaces());
        classes.forEach(System.out::println);
    }

    @Test
    public void testAOPPointCut() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
        ICalculatorService calculatorService = ioc.getBean(ICalculatorService.class);
        int add = calculatorService.add(1, 2);
        System.out.println("add = " + add);
        System.out.println(calculatorService);
        System.out.println(calculatorService.getClass());
    }
}
