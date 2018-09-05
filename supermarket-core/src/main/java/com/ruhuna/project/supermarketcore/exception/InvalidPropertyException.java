package com.ruhuna.project.supermarketcore.exception;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
public class InvalidPropertyException extends RuntimeException {
    public InvalidPropertyException() {
    }

    public InvalidPropertyException(String message) {
        super(message);
    }

    public InvalidPropertyException(String message, Throwable cause) {
        super(message, cause);
    }
}
