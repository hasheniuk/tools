package com.beepbell.tools;

public class JsonException extends RuntimeException {

    public JsonException(String msg) {
        super(msg);
    }

    public JsonException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
