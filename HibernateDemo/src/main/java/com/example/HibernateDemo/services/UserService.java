package com.example.HibernateDemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HibernateDemo.entities.User;
import com.example.HibernateDemo.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	

    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public User GetUserByName(String name) {
        User foundUser = userRepository.findByName(name);
        return foundUser;
    }


}
