package com.aytugakin.account.controller;

import com.aytugakin.account.dto.AccountDto;
import com.aytugakin.account.dto.CreateAccountRequest;
import com.aytugakin.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }

}
