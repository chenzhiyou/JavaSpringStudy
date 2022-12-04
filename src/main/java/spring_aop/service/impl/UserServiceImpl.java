package spring_aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_aop.dao.UserDao;
import spring_aop.entity.User;
import spring_aop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User select(Integer id) throws Exception {
        System.out.println("查询user");
        return userDao.select(id);
    }

    @Override
    public Integer add(User user) throws Exception {
        System.out.println("增加user");
        return userDao.add(user);
    }

    @Override
    public Integer update(User user) throws Exception {
        System.out.println("更新user");
        return userDao.update(user);
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        System.out.println("删除user");
        return userDao.delete(id);
    }
}
