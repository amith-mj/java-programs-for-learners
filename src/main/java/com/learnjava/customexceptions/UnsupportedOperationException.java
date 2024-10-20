package com.learnjava.customexceptions;

/**
 * Custom exception class to handle unsupported operation scenarios.
 */
public class UnsupportedOperationException extends Throwable {
    private String message = null;
    private final String code;

    /**
     * Default constructor that sets the error code to "Unsupported Operation".
     */
    public UnsupportedOperationException() {
        this.code = "Unsupported Operation";
    }

    /**
     * Constructor that accepts a custom error message and sets the error code to "Unsupported Operation".
     *
     * @param message the custom error message
     */
    public UnsupportedOperationException(String message) {
        this.message = message;
        this.code = "Unsupported Operation";
    }

    /**
     * Constructor that accepts a custom error message and a custom error code.
     *
     * @param message the custom error message
     * @param code the custom error code
     */
    public UnsupportedOperationException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    /**
     * Returns a string representation of the exception, including the message and code.
     *
     * @return a string representation of the exception
     */
    @Override
    public String toString() {
        return "UnsupportedOperation{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
