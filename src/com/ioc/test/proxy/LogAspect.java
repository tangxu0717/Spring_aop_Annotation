package com.ioc.test.proxy;

import com.ioc.test.log.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by tangxu on 2017/1/14.
 */
@Component("logAspect")//让这个切面类被Spring所管理
@Aspect//声明这个类是一个切面类，
public class LogAspect {
    /**
     * 第一个*表示任意返回值，第二个*表示这个包中的所有类，第三个*表示以add开头的所有方法，括号中的两点表示任意参数
     */
    @Before(value="execution(* com.ioc.test.dao.*.add*(..))||"+
            "execution(* com.ioc.test.dao.*.delete*(..))")
    public void logStart(JoinPoint jp){
        //得到执行的对象
        System.out.println(jp.getTarget());
        //提到执行的方法
        System.out.println(jp.getSignature().getName());
        Logger.info("加入日志");
    }

    @After(value="execution(* com.ioc.test.dao.*.add*(..))||"+
            "execution(* com.ioc.test.dao.*.delete*(..))")
    public void logEnd(JoinPoint jp){
        Logger.info("方法调用结束加入日志");
    }

    @Around("execution(* com.ioc.test.dao.*.add*(..))||"+
            "execution(* com.ioc.test.dao.*.delete*(..))")
    public void logAround(ProceedingJoinPoint pjp){
        Logger.info("开始在Around中加入日志");
        try {
            pjp.proceed();//执行程序
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Logger.info("结束Around");
    }
}
