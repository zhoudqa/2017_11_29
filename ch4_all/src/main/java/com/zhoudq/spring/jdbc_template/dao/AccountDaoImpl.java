package com.zhoudq.spring.jdbc_template.dao;

import com.zhoudq.spring.jdbc_template.entity.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void insert(Account account) {

    }

    public void update(Account account) {

    }

    public void update(List<Account> accounts) {

    }

    public void delete(Account account) {

    }

    public Account find(long id) {

        //JDBC
        Account account=new Account();
        try {
            preparedStatement=connection.prepareStatement("select id,owner_name,balance,access_time,locked from account where id=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){

                account.setId(resultSet.getLong("id"));
                account.setOwnerName(resultSet.getString("owner_name"));
                account.setAccessTime(resultSet.getTimestamp("access_time"));
                account.setBalance(resultSet.getDouble("balance"));
                account.setLocked(resultSet.getBoolean("locked"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return account;
        }
        /*
        //jdbcTemplate
        return jdbcTemplate.queryForObject("select id,owner_name,balance,access_time,locked from account where id=?", new RowMapper<Account>() {
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account=new Account();
                account.setId(resultSet.getLong("id"));
                account.setOwnerName(resultSet.getString("owner_name"));
                account.setAccessTime(resultSet.getTimestamp("access_time"));
                account.setBalance(resultSet.getDouble("balance"));
                account.setLocked(resultSet.getBoolean("locked"));
                return account;
            }
        },id);
        */
    }

    public List<Account> find(List<Long> ids) {
        return null;
    }

    public List<Account> find(String ownerName) {
        return null;
    }

    public List<Account> find(boolean locked) {
        return null;
    }


}
