package spring_ioc_javaconfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ioc_javaconfig.dao.UserDao;
import spring_ioc_javaconfig.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
