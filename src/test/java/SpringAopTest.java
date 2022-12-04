import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_aop.service.UserService;
import spring_aop.service.impl.UserServiceImpl;
import spring_aop.service.impl.UserServiceImpl2;

public class SpringAopTest {

    static ApplicationContext context;

    @BeforeAll
    public static void beforeAll(){
        context=new ClassPathXmlApplicationContext("spring.xml");
    }

    /**
     * 在没有使用AOP的时候的bean为 spring_aop.service.impl.UserServiceImpl
     * 当使用了AOP的情况下：
     *      com.sun.proxy.$Proxy25
     *          jdk代理所产生一个动态代理类，当被代理的类实现了接口会默认使用jdk代理
     *      spring_aop.service.impl.UserServiceImpl2$$EnhancerBySpringCGLIB$$bd1968a0
     *          CGLib代理所产生一个动态代理类，当被代理的类没有实现接口就会使用cglib代理
     */
    @Test
    public void test() throws Exception {
        UserService bean = context.getBean(UserService.class);
        bean.select(2);
        bean.delete(2);
        System.out.println(bean.getClass());
    }

    @Test
    public void test2(){
        UserServiceImpl2 bean = context.getBean(UserServiceImpl2.class);
        System.out.println(bean.getClass());
    }
}
