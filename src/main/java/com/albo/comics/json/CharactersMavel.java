package com.albo.comics.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersMavel {
    public String character;
    public List<ComicsMarvel> comics;
}
