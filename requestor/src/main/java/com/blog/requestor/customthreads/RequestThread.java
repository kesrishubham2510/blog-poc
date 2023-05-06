package com.blog.requestor.customthreads;

import java.time.LocalTime;
import java.util.concurrent.Callable;

import org.springframework.web.client.RestTemplate;

import com.blog.library.Request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestThread implements Callable<String>{

    RestTemplate restTemplate;
    Request request;
    String url;

    public RequestThread(RestTemplate restTemplate,Request request, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.request = request;
    }

    @Override
    public String call() {
      
      log.info("sending request no."+this.request.getId()+" at:- "+LocalTime.now());
      return this.restTemplate.postForEntity(url, request,String.class).getBody();   
        
    }
    
}
