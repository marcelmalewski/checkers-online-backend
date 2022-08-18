package com.marcel.malewski.checkersonlinebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PlayerNotSavedException extends RuntimeException {
   public PlayerNotSavedException(String message) {
      super(message);
   }
}
