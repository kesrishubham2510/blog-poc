package com.blog.reactiveapi.services;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.library.Message;
import com.blog.library.Request;
import com.blog.reactiveapi.repositories.MessageRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RequestProcessor {

    @Autowired
    private MessageRepository messageRepository;

    public Mono<String> logRequest(Mono<Request> requestMono) {

        LocalTime timeStamp = LocalTime.now();
        return requestMono.flatMap((request) -> {
            String response = String.format("Request has been accepted at:- %s and returned at %s", timeStamp,
                    LocalTime.now());
            log.info(response);
            return Mono.just(response);
        });

    }

    public Mono<Message> saveRequest(Mono<Request> requestMono){
        LocalTime timeStamp = LocalTime.now();
        return requestMono.flatMap((request) -> {
            String response = String.format("Request has been accepted at:- %s and returned at %s", timeStamp,
            LocalTime.now());
            Message message = new Message();
            message.setMessage(response);
            message.setMessageLength(response.length());
            return messageRepository.save(message);
        });
    }



}