import beans.Person;
import beans.User;
import beans.Wife;
import cn.tulingxueyuan.service.UserService;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCHTest {
    static ApplicationContext context;

    @BeforeAll
    public static void beforeAll(){
        context=new ClassPathXmlApplicationContext("spring-ios-hight.xml");

    }

    @Test
    public void test01(){
        System.out.println("Spring已加载");
    }

    /**
     * 懒加载测试
     */
    @Test
    public void test02(){
        System.out.println("懒加载测试");
        Wife wife = context.getBean("wife", Wife.class);
        System.out.println(wife);
    }

    /**
     * 作用域
     */
    @Test
    public void test03(){
        System.out.println("懒加载测试");
        Person person = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);
        System.out.println(person);
        System.out.println(person2);
    }

    /**
     * 使用静态工厂方法进行实例化
     */
    @Test
    public void test04(){
        System.out.println("使用静态工厂方法进行实例化");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * 自动注入
     */
    @Test
    public void test05(){
        System.out.println("使用静态工厂方法进行实例化");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }


    /**
     * 生命周期
     * 1、使用接口的方式实现
     *      1、初始化回调，实现 InitializingBean 重写 afterPropertiesSet 方法
     *      2、销毁回调，实现 DisposableBean 重写 destroy 方法
     * 2、 基于配置的方式实现
     *  会先调用接口方式实现的回调，在使用基于配置的方式实现的回调
     */
    @Test
    public void test06(){
        System.out.println("使用静态工厂方法进行实例化");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * 配置第三方bean
     */
    @Test
    public void test07(){
        System.out.println("配置第三方bean");
        DruidDataSource druid = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(druid);
    }

    @Test
    public void test08(){
        UserService bean = context.getBean(UserService.class);
        bean.getUser();
    }

}
