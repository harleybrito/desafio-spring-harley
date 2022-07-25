package com.harley.desafiospringharley.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harley.desafiospringharley.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  
}
