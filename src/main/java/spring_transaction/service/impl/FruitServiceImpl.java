package spring_transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_transaction.dao.IFruitsDao;
import spring_transaction.entity.Fruits;
import spring_transaction.service.IFruitService;

@Service
public class FruitServiceImpl implements IFruitService {

    @Autowired
    IFruitsDao fruitsDao;

    @Override
    @Transactional
    public Fruits getFruits() {
        return fruitsDao.getFruits();
    }

    /**
     * 转账
     * @Transactional 注解应该写在哪里：
     *      可以标记在类上面(当前类所有的方法都运用上了事务)
     *      可以标记在方法上面，是当前方法生效
     *      也可以在类和方法上面同时都存在，类和方法都存在，会以方法的为准。如果方法上面没有，会以类上面的为准
     *      建议：写在方法上面，控制的粒度更细，建议写在业务逻辑层上，因为只有业务逻辑层才会有嵌套调用的情况
     * 事务配置的属性
     *  isolation:设置事务的隔离级别
     *  用来解决并发事务所产生的一些问题：
     *      并发：同一个时间，多个线程同时进行请求
     *  什么时候会产生并发的问题：在并发情况下，对同一个数据(变量、对象)进行读写操作才会产生并发问题
     *  并发会产生什么问题：
     *      1、脏读：一个事务读取了另一个事务中没有提交的数据，会在本事物中产生的数据不一致的问题
     *      2、不可重复读：一个事务中，多次读取相同的数据，但是读取的结果不一样，会在本事务中产生数据不一致问题，需要进行行锁解决
     *      3、幻影读:一个事务中，多次对数据进行整表数据读取(统计)，但是结果不一样，会在本事务中产生数据不一致的问题，需要锁表
     *      不可重复读重点在在update和delete，而幻读的重点在于insert
     *  propagation：事务的传播行为
     *  noRollbackFor: 那些异常事务可以不回滚
     *  noRollbackForClassName：填写的参数是全类名
     *  rollbackFor： 哪些异常事务需要回滚
     *  rollbackForClassName：填写的参数是全类名
     *  readOnly：设置事务是否为只读事务
     *  timeout：事务超出指定执行时长后自动终止并回滚，单位是秒
     */
    @Override
    @Transactional
    public void trans(){
        sub(); // 张三扣钱
        int i=1/0;
        save(); // 李四加钱
    }

    /**
     * 扣钱
     */
    @Override
    public void sub(){
        System.out.println("张三扣钱");
        fruitsDao.sub();

    }

    /**
     * 存钱
     */
    @Override
    public void save(){
        System.out.println("李四收钱");
        fruitsDao.save();

    }
}
