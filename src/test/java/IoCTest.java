import beans.Person;
import beans.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IoCTest {

    static  ApplicationContext context;

    @BeforeAll
    public static void beforeAll(){
         context=new ClassPathXmlApplicationContext("spring-ioc.xml");

    }

    @Test
    public void test01(){
        // 加载Spring Ioc容器 负责实例化，配置和组装Bean， 容器负责通过读取配置元数据获取有关实例化、配置
        // 和组装哪些对象的说明
        /**
         * ApplicationContext Spring的底层核心接口， 有三种实例化方式
         *      ClassPathXmlApplicationContext  根据项目路径的xml配置来实例化Spring容器
         *      FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化Spring容器
         *      AnnotationConfigApplicationContext 根据Javaconfig 来 配置实例化Spring容器
         * 在容器实例化的时候，就会加载所有的bean
         */
        System.out.println("Spring容器已加载");
        /**
         * 获取bean
         *      1、通过类了来获取bean getBean(User.class);
         *      2、通过bean的名字或者ID来获取bean
         *      3、通过名字+类型
         */
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }

    /**
     * 通过别名获取bean
     */
    @Test
    public void test02(){
        User bean = context.getBean("user2", User.class);
        System.out.println(bean);
    }

    /**
     * 基于setter方法的依赖注入
     */
    @Test
    public void test03(){
        User bean = context.getBean("user", User.class);
        System.out.println(bean);
    }

    /**
     * 基于构造函数的依赖注入
     */
    @Test
    public void test04(){
        User bean = context.getBean("user7", User.class);
        System.out.println(bean);
    }

    /**
     * 复杂的依赖注入
     */
    @Test
    public void test05(){
        Person bean = context.getBean("person", Person.class);
        System.out.println(bean);
    }
}
