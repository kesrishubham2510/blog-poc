package com.blog.mvcapi.components;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blog.library.Request;
import com.blog.mvcapi.services.RequestorProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataPopulator implements CommandLineRunner{
    
    @Autowired
    private RequestorProcessor requestorProcessor;
    
    @Override
    public void run(String... args) throws Exception {
    
        List<Request> requestList = new ArrayList<>();
    
        Request request;
    
        for(int i=0; i<100; i++){
            request = new Request();
            request.setId(i);
            request.setCreationTime(LocalTime.now());
            requestList.add(request);
        }
    
        log.info("Populating database..");
        requestList.forEach(req-> requestorProcessor.saveRequest(req));
        
    }


    
    
}
