package com.zhoudq.datasource.dbconf;

import com.zhoudq.spring.jdbc_template.dao.AccountDao;
import com.zhoudq.spring.jdbc_template.dao.AccountDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfiguration {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;

    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public AccountDao accountDao() throws SQLException{
        AccountDaoImpl accountDao=new AccountDaoImpl();
        accountDao.setJdbcTemplate(jdbcTemplate());
        accountDao.setConnection(dataSource().getConnection());
        return accountDao;
    }
}
