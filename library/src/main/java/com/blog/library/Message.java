package com.blog.library;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Message {
    
    @Id
    private int id;
    private int messageLength;
    private String message;
}
