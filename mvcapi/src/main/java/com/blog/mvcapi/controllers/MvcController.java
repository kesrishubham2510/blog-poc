package com.blog.mvcapi.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.library.Request;
import com.blog.mvcapi.services.Requestor;

@RestController
@RequestMapping("/mvc")
public class MvcController {

    @Autowired
    private Requestor requestor;

    @PostMapping("getLog")
    public String getResponse(@RequestBody Request request) throws InterruptedException, IOException {
        return requestor.logRequest(request);
    }
}