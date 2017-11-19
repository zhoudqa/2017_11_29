package com.zhoudq.ch2.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class A {
    @Autowired
    private B b;

    @PostConstruct
    public void init(){
        System.out.println("A init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("A destroy");
    }
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
