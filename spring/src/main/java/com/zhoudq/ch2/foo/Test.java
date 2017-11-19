package com.zhoudq.ch2.foo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Collections;

public class Test {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.register(FooConfig.class);
        ConfigurableEnvironment environment=applicationContext.getEnvironment();
        environment.setActiveProfiles("prod");
        MutablePropertySources propertySources=environment.getPropertySources();
        propertySources.addLast(
                new MapPropertySource("mapSource", Collections.singletonMap("name",(Object)"my foo")));
        applicationContext.refresh();

        Foo foo=applicationContext.getBean(Foo.class);
        System.out.print(foo.getName());
    }
}
