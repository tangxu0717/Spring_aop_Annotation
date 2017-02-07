package com.ioc.test.action;

import com.ioc.test.User;
import com.ioc.test.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by tangxu on 2017/1/9.
 */
//@Component("userAction")
@Controller("userAction")//MVC的控制器
@Scope(value = "prototype")
public class UserAction {
    private User user;
    private IUserService userService;
    private int id;

    public void add(){
        userService.add(user);
    }

    public void delete(){
        userService.delete(id);
    }

    public void load(){
        userService.load(id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
