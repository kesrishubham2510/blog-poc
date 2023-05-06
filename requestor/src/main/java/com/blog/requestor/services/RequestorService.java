package com.blog.requestor.services;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blog.library.Request;
import com.blog.requestor.customthreads.RequestThread;

@Service
public class RequestorService {

    
    @Autowired
    private RestTemplate restTemplate;
    
    private static final String POST_URL_MVC = "http://localhost:8001/mvc/getLog";

    Request request;
    RequestThread thread;
    ExecutorService service = Executors.newFixedThreadPool(10);

    public String getLogs_MVC() {
        Instant startTime = Instant.now();
        List<Future<String>> responses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            request = new Request();
            request.setCreationTime(LocalTime.now());
            request.setId(i);
            thread = new RequestThread(restTemplate, request, POST_URL_MVC);
            responses.add(service.submit(thread));
        }

        responses.stream().map(futureResponse -> {
            try {
                return futureResponse.get();
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "";
            }
        }).collect(Collectors.toList());

        long executionTime = Duration.between(startTime, Instant.now()).toSeconds();
        return String.format("It took %s seconds to serve this request in mvc pattern", executionTime);

    }
}
