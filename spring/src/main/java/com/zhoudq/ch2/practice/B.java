package com.zhoudq.ch2.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class B {
    @Autowired
    private A a;


    public void init(){
        System.out.println("B init");
    }



    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
