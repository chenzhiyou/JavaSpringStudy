package spring_transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring_transaction.dao.IFruitsDao;
import spring_transaction.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IFruitsDao fruitsDao;

    // 如果事务传播行为是挂起事务，需要将父事务方法和子事务方法写在不同的类里面
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log() {
        fruitsDao.sub();
    }
}
