package com.albo.comics.model;

import javax.persistence.*;

@Entity
@Table(name = "colaborator_comics")
@Cacheable
@NamedQuery(name = "editors.findByCharacter", query = "SELECT colab FROM ColaboratorCharacterMarvelDO colab WHERE colab.nameCharacter = :nameCharacter and colab.rolColaborator = 'editor'")
@NamedQuery(name = "writers.findByCharacter", query = "SELECT colab FROM ColaboratorCharacterMarvelDO colab WHERE colab.nameCharacter = :nameCharacter and colab.rolColaborator = 'writer'")
@NamedQuery(name = "colorists.findByCharacter", query = "SELECT colab FROM ColaboratorCharacterMarvelDO colab WHERE colab.nameCharacter = :nameCharacter and colab.rolColaborator = 'colorist'")
public class ColaboratorCharacterMarvelDO {

    @Id
    @SequenceGenerator(name = "colcomicSequence", sequenceName = "colaborator_comic_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "colcomicSequence")
    private Integer id;

    private Integer idCharacter;

    private String nameCharacter;

    private Integer idComic;

    private String nameComic;

    private String nameColaborator;

    private String rolColaborator;

    public ColaboratorCharacterMarvelDO() {//
    }

    public ColaboratorCharacterMarvelDO(Integer idCharacter, String nameCharacter, Integer idComic, String nameComic, String nameColaborator, String rolColaborator) {
        this.setIdCharacter(idCharacter);
        this.setNameCharacter(nameCharacter);
        this.setIdComic(idComic);
        this.setNameComic(nameComic);
        this.setNameColaborator(nameColaborator);
        this.setRolColaborator(rolColaborator);
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
