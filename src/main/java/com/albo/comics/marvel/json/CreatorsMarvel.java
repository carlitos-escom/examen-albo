package com.albo.comics.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatorsMarvel {
    public Integer available;
    public List<ItemsMarvel> items;
}
