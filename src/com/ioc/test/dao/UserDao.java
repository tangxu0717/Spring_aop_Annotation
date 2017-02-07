package com.ioc.test.dao;

import com.ioc.test.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by tangxu on 2017/1/9.
 */
//等于完成了<bean id="userDao" class=""></bean>
//@Component("userDao")//公共的创建Bean的Annotation
@Repository("userDao")//一般用于Dao的注入
public class UserDao implements IUserDao {
    @Override
    public void add(User user) {
        System.out.println("add:"+user);
    }

    @Override
    public void delete(int id) {
        System.out.println("delete:"+id);
    }

    @Override
    public User load(int id) {
        System.out.println("load:"+id);
        return null;
    }
}
