package com.example.questiontesting.exception;

public class NotFoundProfileException extends RuntimeException {

    public NotFoundProfileException(Long id) {
        super("Not found Profile with id=" + id);
    }
}
