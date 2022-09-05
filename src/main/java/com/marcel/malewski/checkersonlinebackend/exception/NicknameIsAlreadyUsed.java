package com.marcel.malewski.checkersonlinebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NicknameIsAlreadyUsed extends RuntimeException {
    public NicknameIsAlreadyUsed(String message) {
        super(message);
    }
}
