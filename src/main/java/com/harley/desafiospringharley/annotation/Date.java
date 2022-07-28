package com.harley.desafiospringharley.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import com.harley.desafiospringharley.validator.DateValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = DateValidator.class)
@Documented
public @interface Date {
  String message() default "Formato de data não aceito.";

  String pattern();

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}
