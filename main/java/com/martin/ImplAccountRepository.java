package com.martin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by martin on 2016-11-30.
 */
@Component
@Repository
public class ImplAccountRepository implements AccountRepository {


    @PersistenceContext
    private EntityManager em;


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    @Transactional(readOnly = true)
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account", new AccountRowMapper());
    }

    @Override
    @Transactional
    public void addAccount(Account accounts) {
        em.persist(accounts);
    }

    @Override
    public void withdrawCash(Long id, int ammo) {
        String sql = "select balance from account where id=?";
        int balance = (int) jdbcTemplate.queryForObject(
                sql, new Object[]{id}, int.class);


        this.jdbcTemplate.update(
                "update account set balance = balance - ? where id =?", ammo, id);


    }

    @Override
    public void addCash(Long id, int ammo) {
        String sql = "select balance from account where id=?";
        int balance = (int) jdbcTemplate.queryForObject(
                sql, new Object[]{id}, int.class);


        this.jdbcTemplate.update(
                "update account set balance = balance + ? where id = ?",
                ammo, id);
    }


    @Override
    public Account findAccountbyId(Long id) {

        return jdbcTemplate.queryForObject(
                "select * from account where id=?",
                new Object[]{id}, new AccountRowMapper());
    }

    @Override
    public Account findAccountByOwnerName(String owner_Name) {

        return jdbcTemplate.queryForObject(
                "select * from account where owner_Name=?",
                new Object[]{owner_Name}, new AccountRowMapper());
    }

}

class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setOwner_Name(rs.getString("owner_name"));
        account.setBalance(rs.getInt("balance"));
        return account;
    }
}