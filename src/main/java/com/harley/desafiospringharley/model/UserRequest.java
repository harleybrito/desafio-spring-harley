package com.harley.desafiospringharley.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import com.harley.desafiospringharley.annotation.Date;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  @NotBlank(message = "Nome não pode ser vazio")
  private String name;
  @Date(pattern = "dd/MM/yyyy", message = "Formato de data deve ser dd/MM/yyyy.")
  private String age;
  @Pattern(regexp = "(^\\d{8}$)", message = "CEP deve conter somente os 8 dígitos.")
  private String cep;
  @CPF(message = "CPF inválido")
  private String document;
}
