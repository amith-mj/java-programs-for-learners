package com.learnjava.customexceptions;

/**
 * Custom exception class to handle invalid input scenarios.
 */
public class InvalidInputException extends Throwable {
    private String message = null;
    private final String code;

    /**
     * Default constructor that sets the error code to "Invalid Input".
     */
    public InvalidInputException() {
        this.code = "Invalid Input";
    }

    /**
     * Constructor that accepts a custom error message and sets the error code to "Invalid Input".
     *
     * @param message the custom error message
     */
    public InvalidInputException(String message) {
        this.message = message;
        this.code = "Invalid Input";
    }

    /**
     * Constructor that accepts a custom error message and a custom error code.
     *
     * @param message the custom error message
     * @param code    the custom error code
     */
    public InvalidInputException(String message, String code) {
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
        return "InvalidInputException{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
