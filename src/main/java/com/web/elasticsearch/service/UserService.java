package com.web.elasticsearch.service;


import com.web.elasticsearch.dto.UserDtoRequest;
import com.web.elasticsearch.exceptions.DataNotFoundException;
import com.web.elasticsearch.model.User;
import com.web.elasticsearch.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createAndSaveUser(UserDtoRequest userDtoRequest) {
        return this.saveUser(new User(userDtoRequest));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(
                        () ->new DataNotFoundException("user not fount by id :" +  userId ));
    }

    public Iterable<User> findUserByName(String name) {
        return userRepository.findAllByName(name);
    }

    public User updateUser(String userId, UserDtoRequest userDtoRequest) {
        User user = this.findUser(userId);

        user.setName(userDtoRequest.getName());
        user.setLastname(userDtoRequest.getLastname());
        user.setCity(userDtoRequest.getCity());

        return this.saveUser(user);
    }

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public Iterable<User> deleteUser(String userId){
        User user = this.findUser(userId);
        userRepository.delete(user);
        return this.getAllUser();
    }

    public void deleteAllUser(){
        userRepository.deleteAll();
    }

}
