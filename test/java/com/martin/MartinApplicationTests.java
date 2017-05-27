package com.martin;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ImportAutoConfiguration
@SpringBootTest
@Transactional
@SpringApplicationConfiguration(MartinApplication.class)
public class MartinApplicationTests {

    private TestEntityManager entityManager;


    @Autowired
    private ImplAccountRepository implAccountRepository;
    @Autowired
    private AccountRepository accountRepository;


    @PersistenceContext
    private EntityManager em;

    private JdbcTemplate jdbcTemplate;

    private Account account;

    @Before
    public void setUp() {
        account = new Account();
        account.setBalance(500);
        account.setOwner_Name("jan Nowak");
        em.persist(account);

    }

    @Test
    public void addCash() {
        accountRepository.addCash(1L, 500);
        Account account = accountRepository.findAccountbyId(1L);
        assertEquals(1000, account.getBalance());
    }



    @Test
    public void contextLoads() {
    }


    @Test
    public void addAccount() {
        Account account = new Account();
        account.setBalance(100);
        account.setOwner_Name("jan");
        em.persist(account);

        assertThat(account.getOwner_Name()).isEqualTo("jan");


    }


    @Test
    public void findAllAccounts() {
        List<Account> account = accountRepository.findAll();
        assertNotNull(account);


    }


}
