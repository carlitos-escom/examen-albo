package com.albo.comics.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersMarvel {
    public Integer available;
    public String collectionURI;
    public List<ItemsMarvel> items;
}
