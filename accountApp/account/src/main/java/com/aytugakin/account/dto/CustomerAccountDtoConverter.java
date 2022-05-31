package com.aytugakin.account.dto;

import com.aytugakin.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.converter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account from){
        return new CustomerAccountDto(
                Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getTransaction().stream().map(converter::convert).collect(Collectors.toSet()),
                from.getCreationDate());
    }


}
