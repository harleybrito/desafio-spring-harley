package com.harley.desafiospringharley.service;

import com.harley.desafiospringharley.exception.ViacepCallException;
import com.harley.desafiospringharley.model.ViacepResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ViacepServiceTest {
    private final RestTemplate restTemplate = mock(RestTemplate.class);
    private final ViacepResponse viacepResponse = new ViacepResponse(
            "01001-000",
            "Praça da Sé",
            "lado ímpar",
            "Sé",
            "São Paulo",
            "SP",
            "3550308",
            "1004",
            "11",
            "7107"
    );
    private final String cep = "22753200";
    @InjectMocks
    private ViacepService viacepService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("getAddressData deve funcionar")
    public void getAddressDataShouldWorkWithValidCep(){
        when(this.restTemplate
                .getForObject(this.viacepService.getUrl() + this.cep + "/json/", ViacepResponse.class))
                .thenReturn(this.viacepResponse);
        ViacepResponse response = this.viacepService.getAddressData(this.cep);
        assertEquals(this.viacepResponse, response);
    }

    @Test()
    @DisplayName("getAddressData deve estourar exceção 503")
    public void getAddressDataShouldThrowException(){
        when(this.restTemplate
                 .getForObject(this.viacepService.getUrl() + this.cep + "/json/", ViacepResponse.class))
                 .thenThrow(new RuntimeException());
        assertThrows(ViacepCallException.class, () -> this.viacepService.getAddressData(this.cep));
    }
}
