import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import spring_transaction.entity.Fruits;
import spring_transaction.service.IFruitService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringTransactionTest {
    static ApplicationContext context;

    @BeforeAll
    public static void beforeAll(){

        context=new ClassPathXmlApplicationContext("spring-transaction.xml");
    }


    @Test
    public void test01(){
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean);
    }

    /**
     * 查询单个值
     */
    @Test
    public void test02(){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from fruits", Long.class);
        System.out.println(aLong);
    }

    /**
     * 查询实体
     * 数据库字段名和属性名一样，利用BeanPropertyRowMapper
     * 数据库字段名和属性名不一致，利用
     */
    @Test
    public void test03(){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        Fruits fruits = jdbcTemplate.queryForObject("select * from fruits where fid=3",
                new BeanPropertyRowMapper<>(Fruits.class));
        System.out.println(fruits);
    }

    @Test
    public void test04(){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        Fruits fruits = jdbcTemplate.queryForObject("select * from fruits where fid=3",
                (resultSet, i) -> {
                    Fruits f = new Fruits();
                    f.setFid(resultSet.getInt("fid"));
                    return f;
                });
        System.out.println(fruits);
    }

    /**
     * 查询结果为列表
     */
    @Test
    public void test05(){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        List<Fruits> fruits = jdbcTemplate.query("select * from fruits where fid=3",
                new BeanPropertyRowMapper<>(Fruits.class));
        System.out.println(fruits);
    }

    /**
     * 新增
     */
    @Test
    public void test06(){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        int result  =
                jdbcTemplate.update(
                        "insert into fruits(fname, spec, up,t1, t2, inum) values (?, ?, ?, ?, ?,?)",
                "榴莲", "新鲜味美", 25, "哈哈", "是的呢", 10);
        System.out.println(result);
    }

    /**
     * 修改
     */
    @Test
    public void test07(){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        int result  =
                jdbcTemplate.update(
                        "update fruits set inum=30 where fid=?", 3);
        System.out.println(result);
    }


    /**
     * 删除
     */
    @Test
    public void test08(){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        int result  =
                jdbcTemplate.update(
                        "delete from fruits where fid=?", 23);
        System.out.println(result);
    }

    /**
     * 具名参数处理 NamedParameterJdbcTemplate
     */
    @Test
    public void test09(){
        NamedParameterJdbcTemplate jdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
        Map<String, Object> map = new HashMap<>();
        map.put("fid", 22);
        int result  =
                jdbcTemplate.update(
                        "delete from fruits where fid=:fid", map);
        System.out.println(result);
    }

    @Test
    public void test10(){
        IFruitService jdbcTemplate = context.getBean(IFruitService.class);
        Fruits fruits = jdbcTemplate.getFruits();
        System.out.println(fruits);
    }



}

