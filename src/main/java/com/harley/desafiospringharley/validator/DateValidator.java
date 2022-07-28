package com.harley.desafiospringharley.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import com.harley.desafiospringharley.annotation.Date;
import lombok.Data;

@Data
public class DateValidator implements ConstraintValidator<Date, String> {
  private String pattern;

  @Override
  public void initialize(Date constraintAnnotation) {
      this.pattern = constraintAnnotation.pattern();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.pattern);
    try {
      LocalDate.parse(value, formatter);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
