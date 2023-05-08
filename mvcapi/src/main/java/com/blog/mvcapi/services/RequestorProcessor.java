package com.blog.mvcapi.services;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.library.Message;
import com.blog.library.Request;
import com.blog.mvcapi.repositories.MessageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestorProcessor {

    @Autowired
    private MessageRepository messageRepository;

    public String logRequest(Request request) throws InterruptedException, ExecutionException{
        LocalTime timeStamp = LocalTime.now();
        String response = String.format("Request:- %s, created at:- %s accepted at:- %s returns at %s",
                request.getId(), request.getCreationTime(), timeStamp.toString(), LocalTime.now());
        log.info(response);
        return response;
    }

    public Message saveMessage(Request request){
        LocalTime timeStamp = LocalTime.now();
        Message message = new Message();
        String response = String.format("Request:- %s, created at:- %s accepted at:- %s returns at %s",
        request.getId(), request.getCreationTime(), timeStamp.toString(), LocalTime.now());

        message.setMessage(response);
        message.setMessageLength(response.length());
        return messageRepository.save(message);
    }

}