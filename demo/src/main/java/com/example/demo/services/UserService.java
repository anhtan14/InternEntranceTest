package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserService {

    public User findUserById(Long id) throws Exception;

    public User findUserByJwt(String jwt) throws Exception;
}


