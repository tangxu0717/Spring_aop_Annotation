package com.ioc.test.log;

import java.util.Date;

/**
 * Created by tangxu on 2017/1/14.
 */
public class Logger {
    public static void info(String info){
        System.out.println(new Date()+"--->"+info);
    }
}
