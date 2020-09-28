package org.tomaszkowalczyk94.api;

public class UnsupportedOperation extends RuntimeException{
    public UnsupportedOperation() {
        super();
    }

    public UnsupportedOperation(String message) {
        super(message);
    }

    public UnsupportedOperation(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedOperation(Throwable cause) {
        super(cause);
    }
}
