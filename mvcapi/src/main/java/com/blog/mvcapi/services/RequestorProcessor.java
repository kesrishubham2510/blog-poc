package com.blog.mvcapi.services;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.blog.library.Request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestorProcessor {

    public String logRequest(Request request) throws InterruptedException, ExecutionException{
        LocalTime timeStamp = LocalTime.now();
        
        // Mimicing an api call which takes 5 seconds to complete
        CompletableFuture<String> mimicCall = CompletableFuture.supplyAsync(()->{
             try {
                Thread.sleep(5000);
                return String.valueOf(request.getId());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
              return "Exceptionn occured";
        });
        mimicCall.get();

        String response = String.format("Request:- %s, created at:- %s accepted at:- %s returns at %s",
                mimicCall.get(), request.getCreationTime(), timeStamp.toString(), LocalTime.now());
        log.info(response);
        return response;
    }

}