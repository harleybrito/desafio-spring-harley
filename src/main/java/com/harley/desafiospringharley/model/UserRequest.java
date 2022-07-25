package com.harley.desafiospringharley.model;

import lombok.Data;

@Data
public class UserRequest {
  private String name;
  private String age;
  private String cep;
  private String document;
}
