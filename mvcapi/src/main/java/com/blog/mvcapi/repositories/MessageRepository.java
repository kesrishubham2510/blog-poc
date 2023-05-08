package com.blog.mvcapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.library.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

   
}
