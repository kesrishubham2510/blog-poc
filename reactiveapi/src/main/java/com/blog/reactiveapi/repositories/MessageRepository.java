package com.blog.reactiveapi.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.blog.library.Message;

@Repository
public interface MessageRepository extends R2dbcRepository<Message,Integer>{
    
}
