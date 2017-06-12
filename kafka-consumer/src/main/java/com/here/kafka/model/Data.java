package com.here.kafka.model;

/**
 * Created by risingh on 5/28/17.
 */
public class Data {

    String id;

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Data(){}
    public Data(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;
}
