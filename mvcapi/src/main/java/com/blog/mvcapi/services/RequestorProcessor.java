package com.blog.mvcapi.services;

import java.io.IOException;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.blog.library.Request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestorProcessor {

    public String logRequest(Request request) throws InterruptedException, IOException {
        LocalTime timeStamp = LocalTime.now();
        Thread.sleep(5000);
        String response = String.format("Request:- %s, created at:- %s accepted at:- %s returns at %s",
                request.getId(), request.getCreationTime(), timeStamp.toString(), LocalTime.now());
        log.info(response);
        return response;
    }

}