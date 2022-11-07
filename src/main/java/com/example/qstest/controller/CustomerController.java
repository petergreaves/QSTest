package com.example.qstest.controller;

import com.example.qstest.model.Customer;
import com.example.qstest.model.SearchResult;
import com.example.qstest.service.CustomerSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

    private final CustomerSearchService customerSearchService;

    @GetMapping({"/", ""})
    public SearchResult findAll(){

        List<Customer> customers = customerSearchService.findAllCustomers();
        return SearchResult.builder().customers(customers).count(customers.size()).build();

    }

    @GetMapping("/search")
    public SearchResult findWithParams(){

        return null;
    }

}
