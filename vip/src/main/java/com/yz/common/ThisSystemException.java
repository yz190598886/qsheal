package com.yz.common;

public class ThisSystemException extends  RuntimeException {
    public ThisSystemException() {
    }

    public ThisSystemException(String message) {
        super(message);
    }

    public ThisSystemException(String message, Throwable cause) {
        super(message, cause);
    }

}
