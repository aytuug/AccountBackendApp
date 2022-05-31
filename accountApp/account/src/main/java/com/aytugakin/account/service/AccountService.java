package com.aytugakin.account.service;

import com.aytugakin.account.dto.AccountDto;
import com.aytugakin.account.dto.AccountDtoConverter;
import com.aytugakin.account.dto.CreateAccountRequest;
import com.aytugakin.account.model.Account;
import com.aytugakin.account.model.Customer;
import com.aytugakin.account.model.Transaction;
import com.aytugakin.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId())  ;
        Account account = new Account(
                customer,
                createAccountRequest.getInitalCredit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitalCredit().compareTo(BigDecimal.ZERO) > 0){
            //Transaction transaction = transactionService.initiateMoney(account,createAccountRequest.getInitalCredit());
            Transaction transaction = new Transaction(createAccountRequest.getInitalCredit(), account);
            account.getTransaction().add(transaction);
        }


        return converter.convert(accountRepository.save(account));
    }



}
