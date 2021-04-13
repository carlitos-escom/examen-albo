package com.albo.comics.service;

import com.albo.comics.marvel.json.ItemsMarvel;
import com.albo.comics.marvel.json.ResponseMarvel;
import com.albo.comics.marvel.json.ResultsMarvel;
import com.albo.comics.model.CharacterComicMarvelDO;
import com.albo.comics.model.ColaboratorComicMarvelDO;
import com.albo.comics.model.ComicMarvelDO;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MarvelService {
    private static final Logger LOG = Logger.getLogger(MarvelService.class);

    @Inject
    @RestClient
    MarvelRestClientService marvelRestClientService;

    @Inject
    EntityManager entityManager;

    @Transactional
    public ResponseMarvel getComics() {

        ResponseMarvel result = marvelRestClientService.getComics("1", "5370db29c7ea52c91709fb07bfa3dad2", "a9ede1f6ca08c0eb01b83ab9d2135d15", "");
        LOG.info("Total:" + result.data.total);



        List<ResultsMarvel>  results =  result.data.results;
        List<ComicMarvelDO> comicMarvelDOList = new ArrayList<>();
        List<ColaboratorComicMarvelDO> colaboratorComicMarvelDOList = new ArrayList<>();
        List<CharacterComicMarvelDO> characterComicMarvelDOList = new ArrayList<>();

        for(ResultsMarvel resultsMarvel : results){
            entityManager.persist(new ComicMarvelDO(resultsMarvel.id, resultsMarvel.title));


            List<ItemsMarvel> itemsCreators = resultsMarvel.creators.items;
            for(ItemsMarvel itemsMarvel : itemsCreators){
                entityManager.persist(new ColaboratorComicMarvelDO(resultsMarvel.id, resultsMarvel.title, itemsMarvel.name, itemsMarvel.role));
            }

            List<ItemsMarvel> itemsCharacters = resultsMarvel.characters.items;
            for(ItemsMarvel itemsMarvel : itemsCharacters){
                entityManager.persist(new CharacterComicMarvelDO(itemsMarvel.name, resultsMarvel.id, resultsMarvel.title));
            }
        }

        return result;
    }
}