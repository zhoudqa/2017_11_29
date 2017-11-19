package com.zhoudq.ch2.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("ch2-bean.xml");

        B b=applicationContext.getBean("b",B.class);
        A a=applicationContext.getBean("a",A.class);
    }
}
