package com.example.qstest.comtroller;

import com.example.qstest.model.Customer;
import com.example.qstest.service.CustomerSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    private final CustomerSearchService customerSearchService;

    @GetMapping({"/", ""})
    public List<Customer> findAll(){

        return customerSearchService.findAllCustomers();
    }

    @GetMapping("/search")
    public List<Customer> findWithParams(){

        return customerSearchService.findCustomersWithParams();
    }

}
