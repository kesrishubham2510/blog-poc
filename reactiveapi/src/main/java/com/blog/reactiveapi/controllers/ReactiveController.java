package com.blog.reactiveapi.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.library.Request;
import com.blog.reactiveapi.services.RequestProcessor;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/reactive")
public class ReactiveController{

    @Autowired
    private RequestProcessor requestProcessor;

    @PostMapping("getLog")
    public Mono<String> getResponse(@RequestBody Mono<Request> request) throws InterruptedException, IOException{
        return requestProcessor.logRequest(request);
    }

}