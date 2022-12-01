package cn.tulingxueyuan.controller;

import cn.tulingxueyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    /**
     * 使用autowired来实现自动注入
     * byType还是byName
     * 1、默认优先根据类型去匹配
     * 如果匹配到多个类型则会按照名字匹配
     * 如果名字也没有匹配到则会报错
     *      可以修改属性的名字对应的bean的名字
     *      可以去修改bean的名字对应属性的名字 @Service("修改后的名字")
     *      可以通过Qualifier来设置属性的别名
     *      可以通过Primary设置为自动注入的主要的bean
     *      使用泛型作为自动注入限定符
     */
    @Autowired
    UserService userService;

    public void getUser(){
        userService.getUser();
    }
}
