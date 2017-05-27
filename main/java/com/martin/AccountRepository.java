package com.martin;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martin on 2016-11-30.
 */
@Repository
interface AccountRepository {
    List<Account> findAll();

    public void addAccount(Account accounts);

    public void withdrawCash(Long id, int ammo);

    public void addCash(Long id, int ammo);

    public Account findAccountbyId(Long id);

    public Account findAccountByOwnerName(String owner_Name);


}
