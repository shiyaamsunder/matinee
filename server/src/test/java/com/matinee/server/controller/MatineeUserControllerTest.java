package com.matinee.server.controller;

import com.matinee.server.converter.MatineeUserConverter;
import com.matinee.server.service.impl.MatineeUserServiceImpl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(MatineeUserController.class)
@ExtendWith(MockitoExtension.class)
public class MatineeUserControllerTest {

    @Autowired
    MockMvc mvc;

    @MockitoBean
    private MatineeUserServiceImpl matineeUserService;

    @MockitoBean
    private MatineeUserConverter matineeUserConverter;

}
