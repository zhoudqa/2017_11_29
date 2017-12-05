package com.zhoudq.test;

import com.zhoudq.datasource.dbconf.DBConfiguration;
import com.zhoudq.spring.jdbc_template.dao.AccountDao;
import com.zhoudq.spring.jdbc_template.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import java.sql.SQLException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SQLException{
       AnnotationConfigApplicationContext applicationContext=
               new AnnotationConfigApplicationContext(DBConfiguration.class);
       long begin=System.currentTimeMillis();
        AccountDao accountDao=applicationContext.getBean(AccountDao.class);
        Account account=accountDao.find(100L);
        System.out.println(account.getId());
        System.out.println(account.getOwnerName());
        System.out.println(account.getBalance());
        System.out.println(account.getAccessTime());
        System.out.println(account.isLocked());
        System.out.println(System.currentTimeMillis()-begin);

    }
}
