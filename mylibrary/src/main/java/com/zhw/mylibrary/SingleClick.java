package com.zhw.mylibrary;

/*
 * ：Created by z on 2020/9/14
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//对函数注解
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface SingleClick {
    public int value();
    public int delay();
}