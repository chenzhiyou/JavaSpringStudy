package spring_ioc_javaconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import spring_ioc_javaconfig.beans.MyImportBeanDefinitionRegister;
import spring_ioc_javaconfig.beans.MyImportSelector;

/**
 * 用户标记一个Spring配置类，之前是根据xml启动Spring上下文，现在根据类来进行启动
 * 相当于XML文件<beans></beans>
 * 使用PropertySource 引入外部属性资源文件
 * 使用Import 引入其他的配置类(需要在主配置类中引入)，也可以将类注册为bean
 */
@Configuration
@ComponentScan(basePackages = "spring_ioc_javaconfig")
@PropertySource("classpath:db.properties")
/**
 * Import
 * 1、引入其他的配置类(需要在主配置类中引入)
 * 2、导入类注册为bean
 * 3、导入ImportSelector实现类，可以注册多个bean
 * 4、导入MyImportBeanDefinitionRegister实现类，可以注册多个beanDefinition
 */
@Import(MyImportBeanDefinitionRegister.class)
public class IoCJavaConfig {
    /**
     *  <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource"> id就是方法名
     *         <property name="name" value="${mysql.username}"></property>
     *         <property name="password" value="3158218k@"></property>
     *         <property name="url" value="jdbc:mysql://localhost:3306/fruitday"></property>
     *         <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"></property>
     *     </bean>
     * @return
     */
    /**
     * Bean可以将一个类的实例(可以干预Bean实例化过程)注册为一个Bean
     * 会自动将返回值作为Bean的类型，将方法名作为Bean的ID
     * @Bean(name="") 设置bean的名字及别名(替换)
     * @return
     * 怎么去自动依赖外部bean：直接在方法里面写上需要依赖的参数即可，不需要写@Autowried
     * 怎么去自动依赖内部bean：直接调用方法即可
     */
    @Value("${mysql.username}")
    private String name;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driverClassName}")
    private String driverClassName;

    @Bean()
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(name);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
}
