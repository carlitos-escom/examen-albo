package com.albo.comics.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDataMarvel {
    public String last_sync;
    public List<CharactersMavel> characters;
}
