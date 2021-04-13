package com.albo.comics.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsMarvel {
    public Integer id;
    public String name;
    public String title;
    public String resourceURI;
    public CreatorsMarvel creators;
    public CharactersMarvel characters;
}
