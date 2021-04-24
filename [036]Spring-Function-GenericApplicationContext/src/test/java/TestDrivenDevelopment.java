import com.kapcb.ccc.domain.User;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 23:09
 */
public class TestDrivenDevelopment {

    @Test
    public void testGenericApplicationContext() {
        /**
         * 1、创建 GenericApplicationContext 对象
         */
        GenericApplicationContext ioc = new GenericApplicationContext();
        /**
         * 2、调用 ioc 容器的方法进行注册对象
         */
        ioc.refresh();

        /**
         * Lambda函数表达式进行对象注册
         */
        ioc.registerBean(User.class, User::new);

        /**
         * 从Spring中获取创建的对象
         * 使用类的全路径进行获取注册的Bean实例
         */
        User user = (User) ioc.getBean("com.kapcb.ccc.domain.User");
        System.out.println("user = " + user);
    }

    @Test
    public void testGenericApplicationContextGetBeanByName() {
        GenericApplicationContext ioc = new GenericApplicationContext();
        ioc.refresh();
        /**
         * 进行bean的别名指定
         */
        ioc.registerBean("kapcb", User.class, User::new);
        /**
         * 使用指定的beanName进行获取Bean实例
         */
        User kapcb = (User) ioc.getBean("kapcb");
        System.out.println("kapcb = " + kapcb);
    }

    @Test
    public void testGenericApplicationContextGetBeanByNameAndType() {
        GenericApplicationContext ioc = new GenericApplicationContext();
        ioc.refresh();
        ioc.registerBean("kapcb", User.class, User::new);
        /**
         * 根据指定的beanName和类型获取Bean
         */
        User kapcb = ioc.getBean("kapcb", User.class);
        System.out.println("kapcb = " + kapcb);
    }
}