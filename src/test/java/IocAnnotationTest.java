import cn.tulingxueyuan.beans.User;
import cn.tulingxueyuan.controller.UserController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocAnnotationTest {
    static ApplicationContext context;

    @BeforeAll
    public static void beforeAll(){
        context=new ClassPathXmlApplicationContext("spring_ioc_annotation.xml");
    }

    @Test
    public void test(){
        UserController userController = context.getBean( UserController.class);
        System.out.println(userController);
    }

    @Test
    public void test02(){
        User bean = context.getBean(User.class);
        System.out.println(bean.getName());

    }

    @Test
    public void test03(){
        UserController bean = context.getBean("userController",UserController.class);
        bean.getUser();

    }
}
