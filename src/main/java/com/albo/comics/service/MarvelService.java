package com.albo.comics.service;

import com.albo.comics.json.ColaboratorDataMarvel;
import com.albo.comics.json.EditorMervel;
import com.albo.comics.marvel.json.ItemsMarvel;
import com.albo.comics.marvel.json.ResponseMarvel;
import com.albo.comics.marvel.json.ResultsMarvel;
import com.albo.comics.model.CharacterComicMarvelDO;
import com.albo.comics.model.ColaboratorCharacterMarvelDO;
import com.albo.comics.repository.CharacterRepo;
import com.albo.comics.repository.ColaboratorRepo;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class MarvelService {
    private static final Logger LOG = Logger.getLogger(MarvelService.class);

    @Inject
    @RestClient
    MarvelRestClientService marvelRestClientService;

    @Inject
    ColaboratorRepo colaboratorRepo;

    @Inject
    CharacterRepo characterRepo;

    void onStart(@Observes StartupEvent ev) {
        LOG.info("La aplicacion se iniico ...");
        this.getComics();
    }

    @Transactional
    public ResponseMarvel getComics() {

        ResponseMarvel result = marvelRestClientService.getComics("1", "5370db29c7ea52c91709fb07bfa3dad2", "a9ede1f6ca08c0eb01b83ab9d2135d15", "");
        LOG.info("Total:" + result.data.total);

        List<ResultsMarvel>  results =  result.data.results;

        for(ResultsMarvel resultsMarvel : results){
            LOG.debug("Nombre comic:" + resultsMarvel.title);

            List<ItemsMarvel> itemsCreators = resultsMarvel.creators.items;
            for(ItemsMarvel itemsMarvel : itemsCreators){
                colaboratorRepo.saveColaborator(new ColaboratorCharacterMarvelDO(resultsMarvel.id, resultsMarvel.title, resultsMarvel.id, resultsMarvel.title, itemsMarvel.name, itemsMarvel.role));
            }

            List<ItemsMarvel> itemsCharacters = resultsMarvel.characters.items;
            for(ItemsMarvel itemsMarvel : itemsCharacters){
                characterRepo.saveCharacter(new CharacterComicMarvelDO(itemsMarvel.name, resultsMarvel.id, resultsMarvel.title));
            }
        }

        return result;
    }

    public ColaboratorDataMarvel transformColaborator(String nameCharacter){
        ColaboratorDataMarvel colaboratorDataMarvel = new ColaboratorDataMarvel();
        colaboratorDataMarvel.last_sync = "Fecha de la ultima sincronizacion en " + new Date();

        colaboratorDataMarvel.editors = transformCol(colaboratorRepo.getEditors(nameCharacter));
        colaboratorDataMarvel.writers = transformCol(colaboratorRepo.getWriters(nameCharacter));
        colaboratorDataMarvel.colorists = transformCol(colaboratorRepo.getColorits(nameCharacter));

        return colaboratorDataMarvel;
    }

    public ColaboratorDataMarvel transformCharacter(String nameCharacter){
        ColaboratorDataMarvel colaboratorDataMarvel = new ColaboratorDataMarvel();
        colaboratorDataMarvel.last_sync = "Fecha de la ultima sincronizacion en " + new Date();

        colaboratorRepo.getEditors(nameCharacter);
        colaboratorRepo.getWriters(nameCharacter);
        colaboratorRepo.getColorits(nameCharacter);

        return colaboratorDataMarvel;
    }



    private List<EditorMervel> transformCol(List<ColaboratorCharacterMarvelDO> colaboratorsList){
        List<EditorMervel> colaborators = new ArrayList<>();
        for(ColaboratorCharacterMarvelDO colaboratorCharacterMarvelDO : colaboratorsList){
            EditorMervel editorMervel = new EditorMervel();
            editorMervel.nombre = colaboratorCharacterMarvelDO.getNameColaborator();
            colaborators.add(editorMervel);
        }

        return colaborators;
    }
}