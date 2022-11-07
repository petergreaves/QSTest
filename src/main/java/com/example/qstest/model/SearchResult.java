package com.example.qstest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {

    @JsonProperty("total")
    private Integer count;

    @JsonProperty("results")
    private List<Customer> customers;
}
