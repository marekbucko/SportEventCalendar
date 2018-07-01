package pl.sda.calendar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.calendar.model.User;
import pl.sda.calendar.repository.UserRepository;
import pl.sda.calendar.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/findall")
    @ResponseStatus(HttpStatus.OK)
    public List<User> showEvents() {
        return userRepository.findAll();
    }
}
