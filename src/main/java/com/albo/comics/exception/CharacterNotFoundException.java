package com.albo.comics.exception;

import java.util.UUID;

public class CharacterNotFoundException extends RuntimeException {

  public CharacterNotFoundException(String nameCharacter) {
    super("El personaje: " + nameCharacter + " No existe!");
  }
}
