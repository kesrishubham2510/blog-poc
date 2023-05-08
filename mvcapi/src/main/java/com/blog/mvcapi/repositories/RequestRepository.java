package com.blog.mvcapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.library.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{

   
}
