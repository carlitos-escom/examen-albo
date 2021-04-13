package com.albo.comics.exception;

public class CharacterNotFoundException extends RuntimeException {

  public CharacterNotFoundException(String nameCharacter) {
    super("El personaje: " + nameCharacter + " No existe!");
  }
}
