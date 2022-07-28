package com.harley.desafiospringharley.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
  private String name;
  private String age;
  private String city;
  private String district;
  private String state;
  private String document;
}
