package spring_aop.service;

import spring_aop.entity.User;

public interface UserService {

    User select(Integer id) throws Exception;
    Integer add(User user) throws Exception;
    Integer update(User user) throws Exception;
    Integer delete(Integer id) throws Exception;
}
