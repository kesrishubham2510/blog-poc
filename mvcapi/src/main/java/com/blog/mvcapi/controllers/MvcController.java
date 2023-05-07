package com.blog.mvcapi.controllers;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.library.Request;
import com.blog.mvcapi.services.RequestorProcessor;

@RestController
@RequestMapping("/mvc")
public class MvcController {

    @Autowired
    private RequestorProcessor requestor;

    @PostMapping("getLog")
    public String getResponse(@RequestBody Request request) throws InterruptedException, ExecutionException {
        return requestor.logRequest(request);
    }
}