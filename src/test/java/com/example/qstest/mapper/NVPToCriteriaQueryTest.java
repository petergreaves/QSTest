package com.example.qstest.mapper;

import com.example.qstest.mappers.HashMapToCustomerMapper;
import com.example.qstest.mappers.NameValuePairToCriteriaQueryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class NVPToCriteriaQueryTest {

    @PersistenceContext
    private  EntityManager entityManager;

    private NameValuePairToCriteriaQueryMapper mapper  = null;

    @BeforeEach
    public void setup(){

        mapper
                = Mappers.getMapper(NameValuePairToCriteriaQueryMapper.class);



    }

    @Test
    void contextLoads() {
        Assertions.assertNotNull(entityManager);
    }
}
