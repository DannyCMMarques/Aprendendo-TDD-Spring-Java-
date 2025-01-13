package com.example.todo.demo.Exceptions;

public class RegistrarDuplicationException extends RuntimeException {

    public RegistrarDuplicationException() {
        super();
    }

    public RegistrarDuplicationException(String message) {
        super(message);
    }
}