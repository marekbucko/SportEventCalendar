package pl.sda.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.sda.calendar.exception.UserEmailTakenException;
import pl.sda.calendar.model.User;
import pl.sda.calendar.repository.UserRepository;
import pl.sda.calendar.exception.UserNameTakenException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User newUser){
        if (userRepository.findByUserName(newUser.getUserName()) != null) {
            throw new UserNameTakenException(String.format("user %s already exists", newUser.getUserName()));
        }
        if (userRepository.findByUserEmail(newUser.getUserEmail()) !=null){
            throw new UserEmailTakenException(String.format("e-mail %s already taken",newUser.getUserEmail()));
        }
        userRepository.save(newUser);
        return newUser;
    }

}
