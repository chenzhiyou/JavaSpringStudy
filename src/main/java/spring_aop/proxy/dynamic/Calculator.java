package spring_aop.proxy.dynamic;

public class Calculator implements ICalculator{
    @Override
    public Integer add(Integer i, Integer j) {
        System.out.println("日志：调用了add方法，参数是"+ i+"和"+j);
        Integer result = i + j;
        System.out.println(result);
        return result;
    }

    @Override
    public Integer sub(Integer i, Integer j) {
        Integer result = i - j;
        return result;
    }

    @Override
    public Integer mul(Integer i, Integer j) {
        Integer result = i * j;
        return result;
    }

    @Override
    public Integer div(Integer i, Integer j) {
        Integer result = i / j;
        return result;
    }
}
