package com.albo.comics.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicsMarvel {
    String collectionURI;
    public List<ItemsMarvel> items;
}
