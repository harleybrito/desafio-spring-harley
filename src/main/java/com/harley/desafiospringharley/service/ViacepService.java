package com.harley.desafiospringharley.service;

import lombok.Data;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harley.desafiospringharley.exception.ViacepCallException;
import com.harley.desafiospringharley.model.ViacepResponse;

@Service
@Data
public class ViacepService {
  private final RestTemplate restTemplate;
  private String url = "https://viacep.com.br/ws/";

  public ViacepService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public ViacepResponse getAddressData(String cep){
    try {
      return this.restTemplate.getForObject(this.url + cep + "/json/", ViacepResponse.class);
    } catch (Exception e) {
      throw new ViacepCallException("Busca por endereço falhou em ViaCep.");
    }
  }
}
