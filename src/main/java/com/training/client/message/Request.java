package com.training.client.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"name", "message"})
public class Request {

    @JsonProperty("name")
    private String name;

    @JsonProperty("massage")
    private String message;

    public Request() {
    }

    public Request(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request client = (Request) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(message, client.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, message);
    }
}
