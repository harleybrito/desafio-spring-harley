package com.harley.desafiospringharley.model;

import lombok.Data;

@Data
public class UserResponse {
  private String name;
  private String age;
  private String city;
  private String district;
  private String state;
  private String document;
}
