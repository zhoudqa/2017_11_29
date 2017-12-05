package com.zhoudq.spring.jdbc_template.dao;

import com.zhoudq.spring.jdbc_template.entity.Account;

import java.util.List;

public interface AccountDao {
    void insert(Account account);
    void update(Account account);
    void update(List<Account> accounts);
    void delete(Account account);
    Account find(long id);
    List<Account> find(List<Long> ids);
    List<Account> find(String ownerName);
    List<Account> find(boolean locked);

}
