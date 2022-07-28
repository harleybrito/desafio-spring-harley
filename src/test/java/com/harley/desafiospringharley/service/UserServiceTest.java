package com.harley.desafiospringharley.service;

import com.harley.desafiospringharley.exception.ElementNotFoundException;
import com.harley.desafiospringharley.model.User;
import com.harley.desafiospringharley.model.UserRequest;
import com.harley.desafiospringharley.model.UserResponse;
import com.harley.desafiospringharley.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private final UserRepository userRepository = mock(UserRepository.class);

    private final User mockedUser = new User(
            "sdasdasda",
            "Mariah Sophia Rodrigues",
            "15/04/1996",
            "Rio de Janeiro",
            "Itanhangá",
            "RJ",
            "123456789123"
    );

    private final UserRequest mockedUserRequest = new UserRequest(
            "Mariah Sophia Rodrigues",
            "15/04/1996",
            "12345678",
            "123456789123"
    );

    private final List<User> mockedUsersList = Arrays.asList(this.mockedUser, this.mockedUser);

    private final String mockedId = "asdadasdasd";

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("save deve funcionar")
    public void saveShouldWork(){
        when(this.userRepository
                .save(this.mockedUser))
                .thenReturn(this.mockedUser);
        User testUser = this.userService.save(this.mockedUser);
        assertEquals(testUser, this.mockedUser);
    }

    @Test
    @DisplayName("findById deve funcionar")
    public void findByIdShouldWork(){
        when(this.userRepository.findById(this.mockedId)).thenReturn(Optional.of(this.mockedUser));
        User testUser = this.userService.findById(this.mockedId);
        assertEquals(testUser, this.mockedUser);
    }

    @Test
    @DisplayName("findById deve lançar ElementNotFoundException")
    public void findByIdShouldThrowElementNotFoundException(){
        when(this.userRepository.findById(this.mockedId)).thenReturn(Optional.empty());
        assertThrows(ElementNotFoundException.class, () -> this.userService.findById(this.mockedId));
    }

    @Test
    @DisplayName("findAll deve funcionar")
    public void findAllShouldWork(){
        when(this.userRepository.findAll()).thenReturn(this.mockedUsersList);
        List<User> testedUsersList = this.userService.getAll();
        assertEquals(testedUsersList, this.mockedUsersList);
    }

    @Test
    @DisplayName("convertToUserResponse deve funcionar")
    public void convertToUserResponseShouldWork(){
        UserResponse userResponse = this.userService.convertToUserResponse(this.mockedUser);
        assertEquals(userResponse, new UserResponse(
                this.mockedUser.getName(),
                this.mockedUser.getAge(),
                this.mockedUser.getCity(),
                this.mockedUser.getDistrict(),
                this.mockedUser.getState(),
                this.mockedUser.getDocument()));
    }

    @Test
    @DisplayName("convertToUserResponse deve funcionar")
    public void convertToUserShouldWork(){
        User user = this.userService.convertToUser(this.mockedUserRequest);
        assertEquals(user, new User(
                null,
                this.mockedUserRequest.getName(),
                this.mockedUserRequest.getAge(),
                null,
                null,
                null,
                this.mockedUserRequest.getDocument()
        ));
    }
}
