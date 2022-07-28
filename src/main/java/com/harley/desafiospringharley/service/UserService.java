package com.harley.desafiospringharley.service;
import com.harley.desafiospringharley.model.UserRequest;
import com.harley.desafiospringharley.model.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.harley.desafiospringharley.exception.ElementNotFoundException;
import com.harley.desafiospringharley.model.User;
import com.harley.desafiospringharley.repository.UserRepository;
import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public User save(User user) {
    return this.userRepository.save(user);
  }

  public User findById(String id) {
    return this.userRepository.findById(id).orElseThrow(
      () -> new ElementNotFoundException("Usuário com id='" + id + "' não foi encontrado.")
    );
  }

  public List<User> getAll() {
    return this.userRepository.findAll();
  }


  public UserResponse convertToUserResponse(User user) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(user, UserResponse.class);
  }

  public User convertToUser(UserRequest user) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(user, User.class);
  }
}
