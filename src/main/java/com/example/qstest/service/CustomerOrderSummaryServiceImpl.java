package com.example.qstest.service;

import com.example.qstest.model.Customer;
import com.example.qstest.model.CustomerOrdersSummary;
import com.example.qstest.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerOrderSummaryServiceImpl implements CustomerOrderSummaryService {

    private final OrderRepository orderRepository;

    @Override
    @Cacheable(value="customer", key = "#customerID")
    public CustomerOrdersSummary getOrdersSummaryForCustomer(Long customerID) {

        CustomerOrdersSummary customerOrdersSummary =
                CustomerOrdersSummary
                        .builder()
                        .customerID(customerID)
                        .build();

        final int k = orderRepository.countByCustomerID(customerID);
        if (k>0){
            customerOrdersSummary.setOrderCount(k);
            customerOrdersSummary.setTotalValue(orderRepository.totalByCustomerID(customerID));
            if (log.isDebugEnabled()){
                log.debug("created orders summary {} ", customerOrdersSummary);
            }
        }
        return customerOrdersSummary;
    }
}
