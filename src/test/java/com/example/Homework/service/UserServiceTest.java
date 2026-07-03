package com.example.Homework.service;

import com.example.Homework.model.User;
import com.example.Homework.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private  UserRepository userRepository;
    @InjectMocks
    private UserService userService;


    @Test
    public void shouldReturnUser_whenUserExists (){
        User user = new User();
        user.setId(1L);
        user.setName("John");

        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));
        User result =  userService.getUserById(1L);
        assertEquals("John",result.getName());
    }

    @Test()
    public void shouldThrows_whenUserNotExists (){

        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(  RuntimeException.class ,()->userService.getUserById(1L) );
    }

    @Test
    public void shouldCreateUser(){
        User user = new User();
        user.setName("John");
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        User result = userService.createUser(user);
        assertEquals("John",result.getName());
    }

}