package com.albo.comics.model;

import java.util.Date;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class CharactersMarvel extends PanacheEntity {

    String name;
    Date modified;
}
