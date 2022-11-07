package com.example.qstest.beans;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Getter
public class SupportedParams {

    @Value("${supported.params}")
    private String paramsAsString;

    private Set<String> params;

    @PostConstruct
    public void init(){

       params= Collections.list(new StringTokenizer(paramsAsString, ",")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toSet());


    }
}
