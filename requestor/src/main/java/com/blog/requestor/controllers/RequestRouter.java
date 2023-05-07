package com.blog.requestor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.requestor.services.RequestorService;

@RestController
@RequestMapping("/request-router")
public class RequestRouter {

    @Autowired
    private RequestorService requestorService;

    @GetMapping("/mvc")
    public List<String> getLogs_MVC(){
        return this.requestorService.getLogs_MVC();
    }
}

