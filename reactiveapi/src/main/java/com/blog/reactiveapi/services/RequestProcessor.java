package com.blog.reactiveapi.services;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.blog.library.Request;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RequestProcessor {

    public Mono<String> logRequest(Mono<Request> requestMono) {

        LocalTime timeStamp = LocalTime.now();
        return requestMono.map((request) -> {
            Mono.delay(Duration.ofMillis(5000));
            System.out.println(request.getId()+" "+request.getCreationTime());
            return request;
        }).flatMap((request) -> {
            String response = String.format("Request has been accepted at:- %s and returned at %s", timeStamp,
                    LocalTime.now());
            log.info(response);
            return Mono.just(response);
        });

    }

}