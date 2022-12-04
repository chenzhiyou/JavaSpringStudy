package spring_aop.dao.impl;

import org.springframework.stereotype.Repository;
import spring_aop.dao.UserDao;
import spring_aop.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User select(Integer id) throws Exception {
       // 访问数据库，查询User
        if (id == null){
            throw  new Exception("id 不能为null");
        }
        return new User();
    }

    @Override
    public Integer add(User user) throws Exception {
        if (user == null){
            throw  new Exception("user不能为null");
        }

        return user.getId();
    }

    @Override
    public Integer update(User user) throws Exception {
        if (user == null){
            throw new Exception("user不能为null");
        }

        return user.getId();
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        if (id == null){
            throw new Exception("user不能为null");
        }
        return id;
    }
}
