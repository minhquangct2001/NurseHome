package com.example.cssk.Entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    @Getter
    @Setter
    private String content;
    private String sender;

    // getters, setters, constructors...
}
