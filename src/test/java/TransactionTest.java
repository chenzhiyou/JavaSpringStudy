import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_transaction.service.IFruitService;

public class TransactionTest {
    static ApplicationContext context;

    @BeforeAll
    public static void beforeAll(){

        context=new ClassPathXmlApplicationContext("spring-transaction.xml");
    }

    @Test
    public void test01(){
        IFruitService service = context.getBean(IFruitService.class);
        service.trans();
    }
}
