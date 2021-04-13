package com.albo.comics.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsComicsMarvel {
    public Long id;
    public String title;
    public Date modified;
    public CreatorsMarvel creators;
}
