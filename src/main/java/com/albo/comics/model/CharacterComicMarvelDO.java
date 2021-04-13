package com.albo.comics.model;

import javax.persistence.*;

@Entity
@Table(name = "character_comics")
@Cacheable
@NamedQuery(name = "colaborator.findByCharacter", query = "SELECT charComic FROM CharacterComicMarvelDO charComic WHERE charComic.nameCharacter = :nameCharacter")
public class CharacterComicMarvelDO {

    @Id
    @SequenceGenerator(name = "characcomicSequence", sequenceName = "character_comic_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "characcomicSequence")
    private Integer id;

    private Integer idCharacter;

    private String nameCharacter;

    private Integer idComic;

    private String nameComic;

    public CharacterComicMarvelDO() {//
    }

    public CharacterComicMarvelDO(Integer idCharacter, String nameCharacter, Integer idComic, String nameComic) {
        this.setIdCharacter(idCharacter);
        this.setNameCharacter(nameCharacter);
        this.setIdComic(idComic);
        this.setNameComic(nameComic);
    }

    public CharacterComicMarvelDO(String nameCharacter, Integer idComic, String nameComic) {
        this.setIdCharacter(idCharacter);
        this.setNameCharacter(nameCharacter);
        this.setIdComic(idComic);
        this.setNameComic(nameComic);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Integer idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public Integer getIdComic() {
        return idComic;
    }

    public void setIdComic(Integer idComic) {
        this.idComic = idComic;
    }

    public String getNameComic() {
        return nameComic;
    }

    public void setNameComic(String nameComic) {
        this.nameComic = nameComic;
    }
}
