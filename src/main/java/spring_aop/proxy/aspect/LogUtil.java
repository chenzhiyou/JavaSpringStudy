package spring_aop.proxy.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 设置切面类中的方法是什么时候在哪里执行？
 *      在增强模块的类上面标记
 *      声明为切面
 *      将切面交给Spring去管理
 *      @Aspect
 *      @Component
 */
@Aspect
@Component
public class LogUtil {
    // 前置通知
    @Before("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void before(){
//        System.out.println(method.getName() + "方法运行前，参数是"
//                +(args==null?"": Arrays.asList(args).toString()));
        System.out.println("方法前");
    }

    // 后置通知
    @After("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void after(){
//        System.out.println(method.getName() + "方法运行后，参数是"
//                +(args==null?"": Arrays.asList(args).toString()));
        System.out.println("方法后");
    }

    // 后置异常通知
    @AfterThrowing("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void afterException(){
//        System.out.println("方法报错了" + ex.getMessage());
        System.out.println("方法异常");
    }

    // 后置返回通知
    @AfterReturning ("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void afterEnd(){
        System.out.println("方法返回");
    }
}
