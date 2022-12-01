package com.example.RestDemo.messages;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClientMessage {
    private String status;
    private String content;

    public ClientMessage(String status, String content) {
        this.status = status;
        this.content = content;
    }
    // public

}
