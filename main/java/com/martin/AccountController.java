package com.martin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martin on 2016-11-30.
 */
@Component
@RestController
@RequestMapping("account")
class AccountController {

    public final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addAccount(@RequestBody Account account) {
        accountRepository.addAccount(account);
    }

    @GetMapping()
    List<Account> findAll() {
        return accountRepository.findAll();


    }

    @GetMapping("/{id}")
    Account findAccountById(@PathVariable("id") Long id) {
        return accountRepository.findAccountbyId(id);
    }

    @PostMapping("/updateBalance/{id}/{ammo}")
    public void dodaj(@PathVariable("id") Long id,
                      @PathVariable("ammo") int balance) {

        accountRepository.addCash(id, balance);
    }


    @PostMapping("/withdraw/{id}/{ammo}")
    public void withdraw(@PathVariable("id") Long id,
                         @PathVariable("ammo") int balance) {

        accountRepository.withdrawCash(id, balance);
    }
}
