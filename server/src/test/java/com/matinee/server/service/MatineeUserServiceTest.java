package com.matinee.server.service;


import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.domain.repository.MatineeUserRepository;
import com.matinee.server.exceptions.MatineeNotFoundException;
import com.matinee.server.service.impl.MatineeUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MatineeUserServiceTest {

    @Mock
    private MatineeUserRepository matineeUserRepository;

    @InjectMocks
    private MatineeUserServiceImpl matineeUserService;

    private MatineeUser mockUser;

    @BeforeEach
    void setup(){
        this.mockUser = MatineeUser.builder()
                .userId(UUID.fromString("31277953-2c24-4dc3-9b9d-0ab26da823e2"))
                .userName("mockUser1")
                .role("user")
                .build();

    }

    @Test
    void testGetMatineeUserById(){
        when(matineeUserRepository.findById(mockUser.getUserId())).thenReturn(Optional.ofNullable(this.mockUser));

        MatineeUser matineeUser = matineeUserService.getMatineeUserById(mockUser.getUserId());

        assertNotNull(matineeUser);
        assertEquals(this.mockUser.getUserId(), matineeUser.getUserId());
    }

    @Test
    void testGetMatineeUserByUsername(){

        when(matineeUserRepository.findByUserName(mockUser.getUserName())).thenReturn(Optional.ofNullable(this.mockUser));

        MatineeUser matineeUser = matineeUserService.getMatineeUserByUserName(mockUser.getUserName());

        assertNotNull(matineeUser);
        assertEquals(this.mockUser.getUserName(), matineeUser.getUserName());
    }

    @Test
    void testGetMatineeUserById_WhenNotFound(){
        when(matineeUserRepository.findById(mockUser.getUserId())).thenReturn(Optional.empty());

        assertThrows(MatineeNotFoundException.class, ()-> matineeUserService.getMatineeUserById(mockUser.getUserId()));
    }

    @Test
    void testGetMatineeUserByUserName_WhenNotFound(){
        when(matineeUserRepository.findByUserName(mockUser.getUserName())).thenReturn(Optional.empty());

        assertThrows(MatineeNotFoundException.class, ()-> matineeUserService.getMatineeUserByUserName(mockUser.getUserName()));
    }

    @Test
    void testAddNewMatineeUser(){
        when(matineeUserRepository.save(mockUser)).thenReturn(mockUser);

        MatineeUser savedUser = matineeUserService.addNewMatineeUser(mockUser);

        assertNotNull(savedUser);
    }

}
