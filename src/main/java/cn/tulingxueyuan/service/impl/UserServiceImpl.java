package cn.tulingxueyuan.service.impl;

import cn.tulingxueyuan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.tulingxueyuan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
