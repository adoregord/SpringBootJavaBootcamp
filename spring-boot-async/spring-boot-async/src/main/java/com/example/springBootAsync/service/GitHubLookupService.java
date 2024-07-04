package com.example.springBootAsync.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springBootAsync.model.GithubUser;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GitHubLookupService {

    @Autowired
    RestTemplate restTemplate;

    public GithubUser findUserSync(String user) throws InterruptedException{
        log.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        GithubUser results = restTemplate.getForObject(url, GithubUser.class);
        // Artificial delay of 1s for demonstration purposes
        log.info("artificial delay of 2s.....");
        Thread.sleep(2000L);
        return results;
    }

    @Async
    public CompletableFuture<GithubUser> findUser(String user) throws InterruptedException {
        log.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        GithubUser results = restTemplate.getForObject(url, GithubUser.class);
        // Artificial delay of 1s for demonstration purposes
        log.info("artificial delay of 2s.....");
        Thread.sleep(2000L);
        log.info("awokwokwok");
        return CompletableFuture.completedFuture(results);
    }
}