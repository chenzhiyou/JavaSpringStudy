package spring_aop.proxy.dynamic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK动态代理完成增加日志功能：动态生成代理类
 */
public class MainTest {

    @Test
    public void test(){
        /**
         * ClassLoader loader 类加载器，通常指定的被代理类的接口的类加载器
         * Class<?>[] interfaces 类型，通常指定被来历类的接口的类型
         * InvocationHandler h 委托执行的处理类，日志功能
         */
        Calculator calculator = new Calculator();
       ICalculator proxy = (ICalculator)MainTest.createProxy(calculator);
        Integer div = proxy.div(1, 1);
        System.out.println(div);

    }

    /**
     * 公共JDK动态代理生成方法
     * @return
     */
    public static Object createProxy(Object needProxy){
        ClassLoader classLoader = needProxy.getClass().getClassLoader();
        Class<?>[] interfaces = needProxy.getClass().getInterfaces();
        // 传入被代理的对象
        InvocationHandler handler = new MyInvocationHandler(needProxy);
        // 动态创建代理类
        Object o   = Proxy.newProxyInstance(classLoader, interfaces, handler);

        // 调用
        System.out.println( o.getClass());
        return o;
    }
}
