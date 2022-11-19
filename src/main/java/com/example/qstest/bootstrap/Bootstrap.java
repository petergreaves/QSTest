package com.example.qstest.bootstrap;

import com.example.qstest.model.Customer;
import com.example.qstest.model.Order;
import com.example.qstest.repository.CustomerRepository;
import com.example.qstest.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class Bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository ;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        Customer c1 = Customer.builder()
                .id(1L)
                .name("Abbey Industries")
                .city("Bradford")
                .accountNumber("AD£999")
                .creditLimit(1000)
                .build();
        Customer c2= Customer.builder()
                .id(2L)
                .name("Smiths and Co")
                .city("London")
                .accountNumber("DD55367")
                .creditLimit(200)
                .build();

        Customer c3 = Customer.builder()
                .id(3L)
                .name("Bill's Bricks")
                .city("London")
                .accountNumber("2JUDJL")
                .creditLimit(5000)
                .build();

        List<Customer> c1Saved = customerRepository.saveAll(Arrays.asList(c1,c2,c3));

        Order o1 = Order.builder().id(1L).customerID(c1.getId()).orderValue(100.0d).build();
        Order o2 = Order.builder().id(2L).customerID(c1.getId()).orderValue(200.0d).build();
        Order o3 = Order.builder().id(3L).customerID(c2.getId()).orderValue(1000.0d).build();
        orderRepository.saveAll(Arrays.asList(o1,o2, o3));

        log.info("Loaded {} customers", customerRepository.count());
        log.info("Loaded {} orders", orderRepository.count());

    }
}
