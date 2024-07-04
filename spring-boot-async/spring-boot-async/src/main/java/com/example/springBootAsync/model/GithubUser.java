package com.example.springBootAsync.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUser {
    private String login, url, name;
}
