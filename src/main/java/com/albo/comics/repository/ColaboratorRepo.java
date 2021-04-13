package com.albo.comics.repository;

import com.albo.comics.model.ColaboratorCharacterMarvelDO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ColaboratorRepo {
    @Inject
    EntityManager entityManager;

    String nameCharacterParam = "nameCharacter";

    public void saveColaborator(ColaboratorCharacterMarvelDO colaboratorCharacterMarvelDO){
        entityManager.persist(colaboratorCharacterMarvelDO);
    }

    public List<ColaboratorCharacterMarvelDO> getEditors(String nameCharacter){
        TypedQuery<ColaboratorCharacterMarvelDO> query = entityManager.createNamedQuery("editors.findByCharacter", ColaboratorCharacterMarvelDO.class);
        query.setParameter(nameCharacterParam, nameCharacter);

        return query.getResultList();
    }

    public List<ColaboratorCharacterMarvelDO> getWriters(String nameCharacter){
        TypedQuery<ColaboratorCharacterMarvelDO> query = entityManager.createNamedQuery("writers.findByCharacter", ColaboratorCharacterMarvelDO.class);
        query.setParameter(nameCharacterParam, nameCharacter);

        return query.getResultList();
    }

    public List<ColaboratorCharacterMarvelDO> getColorits(String nameCharacter){
        TypedQuery<ColaboratorCharacterMarvelDO> query = entityManager.createNamedQuery("colorists.findByCharacter", ColaboratorCharacterMarvelDO.class);
        query.setParameter(nameCharacterParam, nameCharacter);

        return query.getResultList();
    }
}
