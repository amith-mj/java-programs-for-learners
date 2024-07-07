package com.learnjava.customexceptions;

public class InvalidInputException extends Throwable {
    private String message = null;
    private final String code;

    public InvalidInputException() {
        this.code = "Invalid Input";
    }
    public InvalidInputException(String message){
        this.message = message;
        this.code = "Invalid Input";
    }

    public InvalidInputException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String toString() {
        return "InvalidInputException{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
