package com.example.qstest.client;

import com.example.qstest.model.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
@TestPropertySource("classpath:application-test.properties")
public class TestRestClient {

    private RestTemplate restTemplate =null;

    @Value("${restclient.test.url}")
    private String url;

    @BeforeEach
    public void setup(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void testClient(){

        SearchResult result = restTemplate.getForObject(url, SearchResult.class);
        Assertions.assertEquals(Objects.requireNonNull(result).getCount(), 6);
        Assertions.assertEquals(result.getCustomers().get(0).getCreditLimit(), 1000);
    }

}
