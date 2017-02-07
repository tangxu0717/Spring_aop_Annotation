package com.ioc.test.proxy;

import com.ioc.test.annotation.LogInfo;
import com.ioc.test.log.Logger;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * 1写一个类实现InvocationHandler接口
 * Created by tangxu on 2017/1/14.
 */
public class LogProxy implements InvocationHandler {
    //2创建要代理的对象
    private Object target;

    private LogProxy(){}

    //3创建一个方法来生成对象，这个方法的参数是要代理的对象，所返回的对象就是代理对象
    public static Object getInstance(Object o){
        LogProxy proxy = new LogProxy();
        proxy.target = o;
        //通过Proxy的方法创建代理对象，第一个参数是要代理对象的classloader，第二个参数是要代理的对象实现的所有接口，
        //第三个参数是实现了InvocationHandler的对象
        //此时的result就是一个代理对象，代理的是o
        Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),proxy);
        return result;
    }

    /**
     * 当有了代理对象之后，不管这个代理对象执行什么方法，都会调用以下的invoke方法
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //Logger.info("进行了相应的操作");
        if(method.isAnnotationPresent(LogInfo.class)){
            LogInfo li = method.getAnnotation(LogInfo.class);
            Logger.info(li.value());
        }
        Object object = method.invoke(target,objects);
        return object;
    }
}
