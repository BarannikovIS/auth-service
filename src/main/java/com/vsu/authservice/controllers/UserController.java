package com.vsu.authservice.controllers;

import com.vsu.authservice.services.UserService;
import com.vsu.authservice.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    long registr(@RequestBody Person person) {
        return userService.registr(person).getId();
    }

    @RequestMapping(method = RequestMethod.GET)
    Person login(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) {
        return userService.login(login, password);
    }
}
