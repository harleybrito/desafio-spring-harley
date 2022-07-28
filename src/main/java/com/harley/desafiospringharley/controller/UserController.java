package com.harley.desafiospringharley.controller;

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
import com.harley.desafiospringharley.model.ViacepResponse;
import com.harley.desafiospringharley.service.UserService;
import com.harley.desafiospringharley.service.ViacepService;
import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
  private final UserService userService;
  private final ViacepService viacepService;

  @GetMapping()
  public List<UserResponse> getAll(){
    List<User> users = this.userService.getAll();
    List<UserResponse> responseUsers = new ArrayList<>();
    users.forEach(user -> responseUsers.add(this.userService.convertToUserResponse(user)));
    return responseUsers;
  }

  @GetMapping("/{id}")
  public UserResponse getById(@PathVariable String id){
    return this.userService.convertToUserResponse(this.userService.findById(id));
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public UserResponse create(@Valid @RequestBody UserRequest user){
    ViacepResponse viacepResponse = this.viacepService.getAddressData(user.getCep());
    User newUser = this.userService.convertToUser(user);
    newUser.setCity(viacepResponse.getLocalidade());
    newUser.setDistrict(viacepResponse.getBairro());
    newUser.setState(viacepResponse.getUf());
    return this.userService.convertToUserResponse(this.userService.save(newUser));
  }
}