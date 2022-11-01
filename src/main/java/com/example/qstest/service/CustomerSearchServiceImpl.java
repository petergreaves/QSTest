package com.example.qstest.service;

import com.example.qstest.model.Customer;
import com.example.qstest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerSearchServiceImpl implements CustomerSearchService {

    private final CustomerRepository customerRepository;
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Customer> findAllCustomers() {

        return StreamSupport
                .stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findCustomersWithParams() {
        return null;
        //entityManager.(Customer.class, )
    }


}
