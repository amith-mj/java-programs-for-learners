package com.learnjava.customexceptions;

public class UnsupportedOperationException extends Throwable{
    private String message = null;
    private final String code;

    public UnsupportedOperationException() {
        this.code = "Unsupported Operation";
    }
    public UnsupportedOperationException(String message){
        this.message = message;
        this.code = "Unsupported Operation";
    }

    public UnsupportedOperationException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String toString() {
        return "UnsupportedOperation{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
