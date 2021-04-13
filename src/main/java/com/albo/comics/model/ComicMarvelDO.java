package com.albo.comics.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comics")
@Cacheable
public class ComicMarvelDO{

    @Id
    private Integer id;

    private String name;

    public ComicMarvelDO() {//
    }

    public ComicMarvelDO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
