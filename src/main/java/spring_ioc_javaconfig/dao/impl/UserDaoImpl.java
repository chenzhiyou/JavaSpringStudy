package spring_ioc_javaconfig.dao.impl;

import org.springframework.stereotype.Repository;
import spring_ioc_javaconfig.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("查询数据库");
    }
}
