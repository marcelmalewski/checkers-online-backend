package com.marcel.malewski.checkersonlinebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException {
   public PlayerNotFoundException(String message) {
      super(message);
   }
}
