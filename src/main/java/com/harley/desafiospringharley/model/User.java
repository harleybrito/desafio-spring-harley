package com.harley.desafiospringharley.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document
public class User {
  @Id
  @JsonProperty("_id")
  private Long id;
  private String name;
  private String age;
  private String city;
  private String district;
  private String state;
  @Id
  private String document;
}