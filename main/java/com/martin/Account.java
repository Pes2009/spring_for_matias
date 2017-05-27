package com.martin;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Transactional
@Entity
class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String owner_Name;

    public Account() {
        super();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner_Name() {
        return owner_Name;
    }

    public void setOwner_Name(String owner_Name) {
        this.owner_Name = owner_Name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance;

    public Account(String owner_name, int balance) {

        this.owner_Name = owner_name;
        this.balance = balance;
    }


}
