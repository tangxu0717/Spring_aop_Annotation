package com.ioc.test.service;

import com.ioc.test.User;
import com.ioc.test.dao.IUserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tangxu on 2017/1/9.
 */
//@Component("userService")
@Service("userService")//一般用于业务层
public class UserService implements IUserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    //默认通过名称注入
    @Resource(name = "userDao")
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User load(int id) {
        return userDao.load(id);
    }
}
