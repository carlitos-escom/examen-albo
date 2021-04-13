package com.albo.comics.repository;

import com.albo.comics.model.CharacterComicMarvelDO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CharacterRepo {
    @Inject
    EntityManager entityManager;

    public void saveCharacter(CharacterComicMarvelDO characterComicMarvelDO){
        entityManager.persist(characterComicMarvelDO);
    }
}
