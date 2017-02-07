package com.ioc.test;

import com.ioc.test.action.UserAction;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tangxu on 2017/1/8.
 */
public class TestSpring {
    private BeanFactory factory  = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void testHello(){
        HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(helloWorld.hello());

        HelloWorld helloWorld2 = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(helloWorld == helloWorld2);

    }

    @Test
    public void testUser01(){
        UserAction ua = factory.getBean("userAction", UserAction.class);
        User u = new User(1,"wukong");
        ua.setUser(u);
        ua.add();
        ua.delete();
    }
}
