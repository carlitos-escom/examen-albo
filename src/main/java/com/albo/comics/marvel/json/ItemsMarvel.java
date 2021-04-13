package com.albo.comics.marvel.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsMarvel {
    public String resourceURI;
    public String name;
    public String role;
}
