package com.example.qstest.mapper;

import com.example.qstest.mappers.HashMapToCustomerMapper;
import com.example.qstest.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class HashMapMapperTest {

    private HashMapToCustomerMapper mapper = null;
    private HashMap<String, Object> customerHashMap = null;

    @BeforeEach
    public void setup(){
        mapper
                = Mappers.getMapper(HashMapToCustomerMapper.class);

        customerHashMap = new LinkedHashMap<String, Object>();
        customerHashMap.put("id",100L);
        customerHashMap.put("accountNo","CBC01");
        customerHashMap.put("customerName","ACME org");
        customerHashMap.put("creditMax", 700);
        customerHashMap.put("city", "London");

    }

    @Test
    public void testHashMapCustomerMapper(){

        Customer c = mapper.hashMapToCustomer(customerHashMap);

        Assertions.assertAll(
                () ->  assertTrue("city", c.getCity().equals(customerHashMap.get("city"))),
                () -> assertTrue("customer name", c.getName().equals(customerHashMap.get("customerName"))),
                () -> assertTrue("account number", c.getAccountNumber().equals(customerHashMap.get("accountNo"))),
                () -> assertTrue("credit limit", c.getCreditLimit().equals(customerHashMap.get("creditMax"))),
                () -> assertTrue("id", c.getId().equals(customerHashMap.get("id")))
        );

    }
}
