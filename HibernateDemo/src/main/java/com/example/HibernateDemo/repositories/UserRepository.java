package com.example.HibernateDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.HibernateDemo.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByName(String name);
}