package com.example.qstest.service;

import com.example.qstest.model.Customer;
import lombok.RequiredArgsConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryBuilderServiceImpl implements QueryBuilderService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public CriteriaQuery<Customer> getQueryFromQueryString(String qs) {

        final List<NameValuePair> params =
                URLEncodedUtils.parse(qs, StandardCharsets.UTF_8);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customer = cq.from(Customer.class);

        List<Predicate> predicates = createPredicates(params, cb, customer);
        cq.where(predicates.toArray(new Predicate[0]));
        return cq;
    }

    private List<Predicate> createPredicates(List<NameValuePair> params,
                                  CriteriaBuilder cb,
                                  Root<Customer> customer){

        List<Predicate> predicates = new ArrayList<>();

        for  (NameValuePair param : params) {
            final String name = param.getName();
            if (name.equals("creditLimit")){
                predicates.add(cb.equal(customer.get(name), Integer.valueOf(param.getValue())));
            }
            else{
                predicates.add(cb.like(customer.get(name), param.getValue()));
            }
        }
        return predicates;
    }
}
