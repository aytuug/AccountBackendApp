package com.aytugakin.account.dto;

import com.aytugakin.account.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer from){

        if (from == null){
            return new AccountCustomerDto("","","");
        }else{
            return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());

        }

    }



}
