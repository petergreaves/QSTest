package com.example.qstest.mappers;

import com.example.qstest.model.Customer;
import org.apache.http.NameValuePair;
import org.mapstruct.Mapper;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

//@Mapper
public interface NameValuePairToCriteriaQueryMapper {

 //   Mapping(expression)
    CriteriaQuery<Customer> nvpToCriteriaQuery(List<NameValuePair> nvps);
}
