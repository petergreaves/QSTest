package com.example.qstest.mappers;

import com.example.qstest.model.Customer;
import org.mapstruct.factory.Mappers;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        HashMapToCustomerMapper mapper
                = Mappers.getMapper(HashMapToCustomerMapper.class);

        LinkedHashMap customerHashMap = new LinkedHashMap<String, Object>();
        customerHashMap.put("id",100L);
        customerHashMap.put("accountNo","CBC01");
        customerHashMap.put("customerName","ACME org");
        customerHashMap.put("creditMax", 700);
        customerHashMap.put("city", "London");
        Customer c = mapper.hashMapToCustomer(customerHashMap);

        System.out.println(c);
    }
}
