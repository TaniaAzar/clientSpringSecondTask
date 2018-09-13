package com.training.client.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Response {

    @JsonProperty("message")
    private String Message;

    public Response() {
    }

    public Response(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response that = (Response) o;
        return Objects.equals(Message, that.Message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Message);
    }
}
