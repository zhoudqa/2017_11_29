package com.zhoudq.ch2.foo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class FooConfig {
    @Bean
    @Profile("dev")
    public Foo DevFoo(@Value("$(name)") String name){
        Foo foo=new Foo();
        foo.setName("dev "+name);
        return foo;
    }

    @Bean
    @Profile("prod")
    public Foo ProdFoo(@Value("$(name)") String name){
        Foo foo=new Foo();
        foo.setName("prod "+name);
        return foo;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
