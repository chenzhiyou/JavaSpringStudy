package spring_aop_proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {


    /**
     * 代理类的执行方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */

    Object traget;
    public MyInvocationHandler(Object traget) {
        this.traget = traget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志：调用了add方法，参数是"+ Arrays.asList(args));
        /**
         * 2个参数
         * Object obj 被代理的对象
         *Object ...args 被代理的方法参数，直接将args传进去
         */
        Object result  = method.invoke(traget, args);
        System.out.println("日志"+ result);
        return result;
    }
}
