package com.blog.library;

import java.time.LocalTime;

import lombok.Data;


@Data
public class Request {
    private int id;
    private LocalTime creationTime;

}
