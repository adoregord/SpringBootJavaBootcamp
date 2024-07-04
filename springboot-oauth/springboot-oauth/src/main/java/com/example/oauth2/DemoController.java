package com.example.oauth2;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    
    @GetMapping("/")
    public String home() {
        return "Hello, public user";
    }

    
    @GetMapping("/secure")
    public Map<String, Object> secured(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("principal.name", principal.getAttribute("name"));
    }

    @GetMapping("/pokeleng")
    public String name(@RequestBody OAuth2User pokeleng){
      return "Asokelengan";
    }
}
