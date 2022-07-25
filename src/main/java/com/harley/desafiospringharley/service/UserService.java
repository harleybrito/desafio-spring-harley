package com.harley.desafiospringharley.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.harley.desafiospringharley.model.User;
import com.harley.desafiospringharley.model.UserResponse;
import com.harley.desafiospringharley.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public UserResponse create(User user) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(this.userRepository.save(user), UserResponse.class);
  }

  public UserResponse getById(String id) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(this.userRepository.findById(id), UserResponse.class);
  }
}
