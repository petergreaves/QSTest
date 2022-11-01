package com.example.qstest.service;

import com.example.qstest.model.Customer;

import java.util.List;

public interface CustomerSearchService {

    List<Customer> findAllCustomers();
    List<Customer> findCustomersWithParams();
}
