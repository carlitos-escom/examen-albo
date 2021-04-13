package com.albo.comics.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColaboratorDataMarvel {
    public String last_sync;
    public List<EditorMervel> editors;
    public List<EditorMervel> writers;
    public List<EditorMervel> colorists;
}
