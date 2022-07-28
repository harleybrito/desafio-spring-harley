package com.harley.desafiospringharley.controller;

import com.harley.desafiospringharley.model.User;
import com.harley.desafiospringharley.model.UserRequest;
import com.harley.desafiospringharley.model.UserResponse;
import com.harley.desafiospringharley.model.ViacepResponse;
import com.harley.desafiospringharley.service.UserService;
import com.harley.desafiospringharley.service.ViacepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    private final UserService userService = mock(UserService.class);
    private final ViacepService viacepService = mock(ViacepService.class);

    private final ViacepResponse viacepMockedResponse = new ViacepResponse(
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

    private final User mockedUser = new User(
            "sdsdsdsdsd",
            "Harley Vitor",
            "15/04/1996",
            "São Paulo",
            "Sé",
            "SP",
            "12345678"
    );

    private final UserRequest mockedUserRequest = new UserRequest(
            "Harley Vitor",
            "15/04/1996",
            "12345678",
            "12345678911"
    );

    private final List<User> mockedUsersList = Arrays.asList(this.mockedUser, this.mockedUser);

    private final List<UserResponse> mockedUserResponseList = Arrays.asList(
            new UserResponse(
                    this.mockedUser.getName(),
                    this.mockedUser.getAge(),
                    this.mockedUser.getCity(),
                    this.mockedUser.getDistrict(),
                    this.mockedUser.getState(),
                    this.mockedUser.getDocument()),
            new UserResponse(
                    this.mockedUser.getName(),
                    this.mockedUser.getAge(),
                    this.mockedUser.getCity(),
                    this.mockedUser.getDistrict(),
                    this.mockedUser.getState(),
                    this.mockedUser.getDocument()
            ));

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("getAll deve funcionar")
    public void getAllShouldWork(){
        when(this.userService.getAll()).thenReturn(this.mockedUsersList);
        when(this.userService.convertToUserResponse(this.mockedUser)).thenReturn(new UserResponse(
                this.mockedUser.getName(),
                this.mockedUser.getAge(),
                this.mockedUser.getCity(),
                this.mockedUser.getDistrict(),
                this.mockedUser.getState(),
                this.mockedUser.getDocument()
        ));
        List<UserResponse> usersList = this.userController.getAll();
        assertEquals(usersList, this.mockedUserResponseList);
    }

    @Test
    @DisplayName("getById deve funcionar")
    public void getByIdShouldWork(){
        when(this.userService.findById(this.mockedUser.getId())).thenReturn(this.mockedUser);
        when(this.userService.convertToUserResponse(this.mockedUser)).thenReturn(new UserResponse(
                this.mockedUser.getName(),
                this.mockedUser.getAge(),
                this.mockedUser.getCity(),
                this.mockedUser.getDistrict(),
                this.mockedUser.getState(),
                this.mockedUser.getDocument()
        ));
        UserResponse userResponse = this.userController.getById(this.mockedUser.getId());
        assertEquals(userResponse, new UserResponse(
                this.mockedUser.getName(),
                this.mockedUser.getAge(),
                this.mockedUser.getCity(),
                this.mockedUser.getDistrict(),
                this.mockedUser.getState(),
                this.mockedUser.getDocument()
        ));
    }

    @Test
    @DisplayName("create deve funcionar")
    public void createShouldWork(){
        when(this.viacepService.getAddressData(this.mockedUserRequest.getCep())).thenReturn(this.viacepMockedResponse);
        when(this.userService.convertToUser(this.mockedUserRequest)).thenReturn(this.mockedUser);
        when(this.userService.convertToUserResponse(this.mockedUser)).thenReturn(new UserResponse(
                this.mockedUser.getName(),
                this.mockedUser.getAge(),
                this.mockedUser.getCity(),
                this.mockedUser.getDistrict(),
                this.mockedUser.getState(),
                this.mockedUser.getDocument()
        ));
        when(this.userService.save(this.mockedUser)).thenReturn(this.mockedUser);
        UserResponse userResponse = this.userController.create(this.mockedUserRequest);
        assertEquals(userResponse, new UserResponse(
                this.mockedUser.getName(),
                this.mockedUser.getAge(),
                this.mockedUser.getCity(),
                this.mockedUser.getDistrict(),
                this.mockedUser.getState(),
                this.mockedUser.getDocument()
        ));
    }
}
