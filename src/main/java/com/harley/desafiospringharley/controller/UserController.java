package com.harley.desafiospringharley.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.harley.desafiospringharley.model.User;
import com.harley.desafiospringharley.model.UserRequest;
import com.harley.desafiospringharley.model.UserResponse;
import com.harley.desafiospringharley.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/{id}")
  public UserResponse getById(@PathVariable String id){
    return this.userService.getById(id);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public UserResponse create(@RequestBody UserRequest user){
    ModelMapper modelMapper = new ModelMapper();
    User fullUser = modelMapper.map(user, User.class);
    return this.userService.create(fullUser);
  }
}
