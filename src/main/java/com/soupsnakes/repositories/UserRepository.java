package com.soupsnakes.repositories;

import com.soupsnakes.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}