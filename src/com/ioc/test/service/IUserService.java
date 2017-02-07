package com.ioc.test.service;

import com.ioc.test.User;

/**
 * Created by tangxu on 2017/1/9.
 */
public interface IUserService {
    public void add(User user);
    public void delete(int id);
    public User load(int id);
}
