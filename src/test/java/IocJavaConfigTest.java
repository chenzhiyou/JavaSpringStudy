import beans.User;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_ioc_javaconfig.IoCJavaConfig;
import spring_ioc_javaconfig.beans.Person;
import spring_ioc_javaconfig.controller.UserController;

public class IocJavaConfigTest {
    static AnnotationConfigApplicationContext context;

    @BeforeAll
    public static void beforeAll(){

        context=new AnnotationConfigApplicationContext(IoCJavaConfig.class);
    }

    @Test
    public void test01(){
        UserController bean = context.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    public void test02(){
//        DruidDataSource bean = context.getBean(DruidDataSource.class);
        DruidDataSource bean = (DruidDataSource)context.getBean("dataSource");
        System.out.println(bean);

    }

    @Test
    public void test03(){
        User bean = (User) context.getBean("user2");
        System.out.println(bean);
    }

    /**
     * @Import(MyImportSelector.class)
     */
    @Test
    public void test04(){
        Person bean = context.getBean(Person.class);
        System.out.println(bean.getName());
    }

    /**
     * MyImportBeanDefinitionRegister
     */
    @Test
    public void test05(){
        Person bean = (Person) context.getBean("person");
        System.out.println(bean.getName());
    }

}
