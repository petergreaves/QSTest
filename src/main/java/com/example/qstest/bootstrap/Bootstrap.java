package com.example.qstest.bootstrap;

import com.example.qstest.model.Customer;
import com.example.qstest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private final CustomerRepository customerRepository ;

    @Override
    public void run(String... args) throws Exception {

        Customer c1 = Customer.builder()
                .id(1L)
                .name("Abbey Industries")
                .city("Bradford")
                .accountNumber("AD£999")
                .creditLimit(BigDecimal.valueOf(1000))
                .build();
        Customer c2= Customer.builder()
                .id(2L)
                .name("Smiths and Co")
                .city("London")
                .accountNumber("DD55367")
                .creditLimit(BigDecimal.valueOf(200))
                .build();

        Customer c3 = Customer.builder()
                .id(3L)
                .name("Bill's Bricks")
                .city("London")
                .accountNumber("2JUDJL")
                .creditLimit(BigDecimal.valueOf(5000))
                .build();

        customerRepository.saveAll(Arrays.asList(c1,c2,c3));
        log.info("Loaded {} customers", customerRepository.count());

    }
}
