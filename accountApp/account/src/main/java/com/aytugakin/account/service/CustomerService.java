package com.aytugakin.account.service;

import com.aytugakin.account.dto.CustomerDto;
import com.aytugakin.account.dto.CustomerDtoConverter;
import com.aytugakin.account.exception.CustomerNotFoundException;
import com.aytugakin.account.model.Customer;
import com.aytugakin.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not find from ID " + id));
    }


    public CustomerDto getCustomerById(String customerId) {

        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}
