package com.harley.desafiospringharley.validator;

import com.harley.desafiospringharley.annotation.Date;
import com.harley.desafiospringharley.model.UserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DateValidatorTest {
    private final String validPattern = "dd/MM/yyyy";
    private final String invalidPattern = "dd/MM/YYYY";
    private final String validAge = "15/04/1996";
    private final String invalidAge = "40/04/1996";
    private UserRequest userRequest = new UserRequest();
    private final Date dateAnnotaion = mock(Date.class);
    private final ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

    @Test
    @DisplayName("initialize")
    public void shouldSetPatternValueWhenInitialized(){
        when(this.dateAnnotaion.pattern()).thenReturn(this.validPattern);
        DateValidator dateValidator = new DateValidator();
        dateValidator.initialize(this.dateAnnotaion);
        this.userRequest = new UserRequest();
        this.userRequest.setAge(this.validAge);
        assertEquals(dateValidator.getPattern(), this.validPattern);
    }

    @Test
    @DisplayName("isValid com argumentos certos")
    public void shouldWorkWithValidArguments(){
        when(this.dateAnnotaion.pattern()).thenReturn(this.validPattern);
        DateValidator dateValidator = new DateValidator();
        dateValidator.initialize(this.dateAnnotaion);
        this.userRequest = new UserRequest();
        this.userRequest.setAge(this.validAge);
        assertTrue(dateValidator.isValid(userRequest.getAge(), this.constraintValidatorContext));
    }

    @Test
    @DisplayName("isValid com padrão incorreto")
    public void shouldWorkWithInvalidPattern(){
        when(this.dateAnnotaion.pattern()).thenReturn(this.invalidPattern);
        DateValidator dateValidator = new DateValidator();
        dateValidator.initialize(this.dateAnnotaion);
        this.userRequest = new UserRequest();
        this.userRequest.setAge(this.validAge);
        assertFalse(dateValidator.isValid(userRequest.getAge(), this.constraintValidatorContext));
    }

    @Test
    @DisplayName("isValid com padrão correto e valor incorreto")
    public void shouldWorkWithInvalidDate(){
        when(this.dateAnnotaion.pattern()).thenReturn(this.validPattern);
        DateValidator dateValidator = new DateValidator();
        dateValidator.initialize(this.dateAnnotaion);
        this.userRequest = new UserRequest();
        this.userRequest.setAge(this.invalidAge);
        assertFalse(dateValidator.isValid(userRequest.getAge(), this.constraintValidatorContext));
    }
}
