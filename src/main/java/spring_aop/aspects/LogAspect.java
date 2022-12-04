package spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

@Aspect // 标记为切面
@Component // 标记为bean组件，才能切入到IOC当中的bean
public class LogAspect {

    /**
     * 访问修饰符：可不写，可以匹配任何一个访问修饰符
     * 返回值：如果是jdk自带类型可以不用写完整限定名，如果是自定义类型需要写上完整限定名，如果被切入的方法返回值不一样，可以
     * 使用*代表所有的返回值都能匹配
     * 包名：cn.* == cn.tulingxueyuan ==cn.任意名字，但是只能匹配一级，比如c就无法匹配
     * 如果要cn.tulingxueyuan.service ==> cn.tulingxueyuyan.service cn.tulingxueyuan.* ==>cn.tulingxueyuan.service.impl就无法匹配
     * cn.tulingxueyuan..* ==>cn.tulingxueyuan.service.impl可以匹配
     * 类名： 可以写* 代表任何名字的类名，也可以*ServiceImpl
     * 方法名： 可以写* 代表任何方法
     * 参数：如果是jdk自带类型可以不用写完整限定名，如果是自定义类型需要写上完整限定名。如果需要匹配任意参数，可以写:..
     * 执行顺序：不管是正常的还是异常的，前置-->方法-->后置，都是会执行的
     */

    // 前置通知
    @Before("execution(* spring_aop.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint){
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 所有参数
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName+ "方法运行，参数是"+ Arrays.asList(args));

    }
    // 后置通知
    @After("execution(* spring_aop.service.impl.*.*(..))")
    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        // 所有参数
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName+ "方法运行，参数是"+ Arrays.asList(args));
        System.out.println("后置通知");
    }
    // 后置异常通知
    @AfterThrowing(value = "execution(* spring_aop.service.impl.*.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        String methodName = joinPoint.getSignature().getName();
        // 所有参数
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName+ "方法运行，参数是"+ Arrays.asList(args));
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw, true));
        String exTrace = sw.getBuffer().toString();
        System.out.println("后置异常通知"+ exTrace);
    }
    // 后置返回通知
    @AfterReturning(value = "execution(* spring_aop.service.impl.*.*(..))",
    returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint,Object returnValue){
        String methodName = joinPoint.getSignature().getName();
        // 所有参数
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName+ "方法运行，参数是"+ Arrays.asList(args));
        System.out.println("返回值为： "+ returnValue);
        System.out.println("后置返回通知");
    }
    // 环绕通知
    @Around(value = "execution(* spring_aop.service.impl.*.*(..))")
    public void arround(ProceedingJoinPoint point){
        String methodName = point.getSignature().getName();
        // 所有参数
        Object[] args = point.getArgs();
        Object returnResult="";
        try {
            System.out.println("前置通知"+ methodName + "方法运行，参数是"+ Arrays.asList(args));
            returnResult = point.proceed();
            System.out.println("后置通知"+ methodName + "方法运行，参数是"+ Arrays.asList(args));

        } catch (Throwable e) {
            System.out.println("异常通知"+ e);
        }finally {
            System.out.println("返回通知"+ returnResult);
        }
        System.out.println(methodName+ "方法运行，参数是"+ Arrays.asList(args));

    }
}
