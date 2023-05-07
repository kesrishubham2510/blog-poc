package com.blog.reactiveapi.services;

import java.io.IOException;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.blog.library.Request;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RequestProcessor{

    public Mono<String> logRequest(Mono<Request> requestMono){
        
        return requestMono.flatMap((request)->{       
            LocalTime timeStamp = LocalTime.now();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String response = String.format("Request has been accepted at:- %s and returned at %s",timeStamp, LocalTime.now());
            log.info(response);
            return Mono.just(response);
        });

    }

    
}