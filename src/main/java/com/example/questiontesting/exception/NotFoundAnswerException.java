package com.example.questiontesting.exception;

public class NotFoundAnswerException extends RuntimeException {

    public NotFoundAnswerException(Long id) {
        super("Not found Answer with id=" + id);
    }
}
