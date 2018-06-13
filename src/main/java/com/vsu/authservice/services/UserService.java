package com.vsu.authservice.services;

import com.vsu.authservice.entities.Person;
import com.vsu.authservice.repositories.UserRepository;
import com.vsu.authservice.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    Encoder encoder;

    public Person registr(Person person) {
        try {
            person.setPassword(encoder.code(person.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userRepository.save(person);
    }

    public Person login(String login, String password) {
        Person user = userRepository.findByLogin(login);
        try {
            if (user != null && (encoder.code(password)).equals(user.getPassword())){
                return user;
            }
            else {
                throw new IllegalArgumentException("User not found");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
