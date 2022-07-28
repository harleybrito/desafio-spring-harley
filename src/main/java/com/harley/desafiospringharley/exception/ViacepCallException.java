package com.harley.desafiospringharley.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ViacepCallException extends RuntimeException {
  public ViacepCallException(String message) {
    super(message);
  }
}
