package com.harley.desafiospringharley.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @JsonProperty("_id")
  private String id;
  private String name;
  private String age;
  private String city;
  private String district;
  private String state;
  private String document;
}