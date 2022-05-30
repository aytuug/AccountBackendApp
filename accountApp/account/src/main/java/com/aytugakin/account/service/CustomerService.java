package com.aytugakin.account.service;

import com.aytugakin.account.exception.CustomerNotFoundException;
import com.aytugakin.account.model.Customer;
import com.aytugakin.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not find from ID " + id));
    }




}
