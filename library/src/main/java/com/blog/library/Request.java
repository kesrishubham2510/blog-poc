package com.blog.library;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Request {

    @Id
    private int id;
    private LocalTime creationTime;

}
