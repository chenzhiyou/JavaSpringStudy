package spring_aop.dao;

import spring_aop.entity.User;

public interface UserDao {
    User select(Integer id) throws Exception;
    Integer add(User user) throws Exception;
    Integer update(User user) throws Exception;
    Integer delete(Integer id) throws Exception;
}
