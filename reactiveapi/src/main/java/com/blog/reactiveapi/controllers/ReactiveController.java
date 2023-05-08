package com.blog.reactiveapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.library.Message;
import com.blog.library.Request;
import com.blog.reactiveapi.services.RequestProcessor;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/reactive")
public class ReactiveController{

    @Autowired
    private RequestProcessor requestProcessor;

    @PostMapping("post-message")
    public Mono<Message> getResponse(@RequestBody Mono<Request> request){
        return requestProcessor.saveRequest(request);
    }
}