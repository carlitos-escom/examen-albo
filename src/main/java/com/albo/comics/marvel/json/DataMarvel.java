package com.albo.comics.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataMarvel {
    public String limit;
    public Integer count;
    public Integer total;
    public List<ResultsMarvel> results;
}
