package com.simplilearn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.spring.jpa.User;
import com.simplilearn.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> list() {

        /*
         * Add some Business Logic to process the list.
         */

        return this.userRepository.findAll();
    }

    public void createUser(User user) {

        this.validateUser(user);

        user.setStatus("A");
        this.userRepository.save(user);
    }

    public User findUser(User user) {
        return this.userRepository.findByIdUserNotAndUsernameIgnoreCase(user.getIdUser(), user.getUsername());
    }


    public User findUser(int idUser) {
        return this.userRepository.findById(idUser).orElse(null);
    }

    public void updateUser(User user) {

        this.validateUser(user);

        this.userRepository.findById(user.getIdUser())
                              .ifPresent(u -> {
                                  u.setFirstName(user.getFirstName());
                                  u.setLastName(user.getLastName());
                                  u.setUsername(user.getUsername());
                                  u.setBirth(user.getBirth());

                                  this.userRepository.save(u);
                              });
    }

    public void deleteUser(int idUser) {
        this.userRepository.deleteById(idUser);
    }

    private void validateUser(User user) {
        if (user.getFirstName().isEmpty() ||
            user.getLastName().isEmpty() ||
            user.getUsername().isEmpty()) {
            throw new RuntimeException("Invalid User Data: " + user);
        }

    }
}
