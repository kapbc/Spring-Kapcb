import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.proxy.CgLibAutoDynamicProxy;
import org.junit.Test;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7 21:36
 */
public class TestDrivenDevelopment {

    @Test
    public void testCgLibAutoDynamicProxy(){
        CgLibAutoDynamicProxy cgLibAutoDynamicProxy = new CgLibAutoDynamicProxy();
        User user = (User) cgLibAutoDynamicProxy.CreateProxyObject(User.class);
        System.out.println("user = " + user);
        System.out.println("user.getClass() = " + user.getClass());
    }
}
