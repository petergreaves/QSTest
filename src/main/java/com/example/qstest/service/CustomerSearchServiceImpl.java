package com.example.qstest.service;

import com.example.qstest.model.Customer;
import com.example.qstest.cache.CustomerOrdersSummary;
import com.example.qstest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerSearchServiceImpl implements CustomerSearchService {

    private final CustomerRepository customerRepository;
    private final CustomerOrderSummaryService customerOrdersSummaryService;

    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Customer> findAllCustomers() {

        return customerRepository
                .findAll()
                .stream()
                .map(c -> {
                    final CustomerOrdersSummary summary= customerOrdersSummaryService.getOrdersSummaryForCustomer(c.getId());
                    c.setOrderCount(summary.getOrderCount());
                    c.setOrdersValue(summary.getTotalValue());
                    return c;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Customer> findCustomersWithParams() {
        return null;
        //entityManager.(Customer.class, )
    }


}
