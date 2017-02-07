package com.ioc.test.dao;

import com.ioc.test.User;
import com.ioc.test.annotation.LogInfo;

/**
 * Created by tangxu on 2017/1/9.
 */
public interface IUserDao {
    @LogInfo("添加用户信息")
    public void add(User user);
    @LogInfo("删除用户信息")
    public void delete(int id);
    public User load(int id);
}
