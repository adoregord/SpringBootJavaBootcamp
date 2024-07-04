package com.example.sqql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sqql.model.User;
import com.example.sqql.repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON with the users
        return userRepository.findAll();
    }

    @GetMapping(path = "/findUser")
    public @ResponseBody List<User> findUser(@RequestParam String name, @RequestParam String email){
        return userRepository.findUserUsingQuery(name, email);
    }
    
    @GetMapping(path = "/findUserNative")
    public @ResponseBody List<User> findUserNative(@RequestParam String name, @RequestParam String email){
        return userRepository.findUserUsingNativeQuery(name, email);
    }
    
    @GetMapping(path = "/findUserLike")
    public @ResponseBody List<User> findUserLike(@RequestParam String email){
        return userRepository.findUserUsingNativeQueryLike(email);
    }
}
