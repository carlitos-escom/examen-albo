package com.albo.comics.model;

import javax.persistence.*;

@Entity
@Table(name = "colaborator_comics")
@Cacheable
public class ColaboratorComicMarvelDO {

    @Id
    @SequenceGenerator(name = "colcomicSequence", sequenceName = "colaborator_comic_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "colcomicSequence")
    private Integer id;

    private Integer idComic;

    private String nameComic;

    private String nameColaborator;

    private String rolColaborator;

    public ColaboratorComicMarvelDO() {//
    }

    public ColaboratorComicMarvelDO(Integer idComic, String nameComic, String nameColaborator, String rolColaborator) {
        this.setIdComic(idComic);
        this.setNameComic(nameComic);
        this.setNameColaborator(nameColaborator);
        this.setRolColaborator(rolColaborator);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNameColaborator() {
        return nameColaborator;
    }

    public void setNameColaborator(String nameColaborator) {
        this.nameColaborator = nameColaborator;
    }

    public String getRolColaborator() {
        return rolColaborator;
    }

    public void setRolColaborator(String rolColaborator) {
        this.rolColaborator = rolColaborator;
    }
}
