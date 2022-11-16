package com.example.questiontesting.exception;

public class NotFoundQuestionException extends RuntimeException {

    public NotFoundQuestionException(Long id) {
        super("Not found Question with id=" + id);
    }
}
