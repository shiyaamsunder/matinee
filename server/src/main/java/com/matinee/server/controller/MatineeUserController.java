package com.matinee.server.controller;

import com.matinee.server.converter.MatineeUserConverter;
import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.dto.MatineeResponse;
import com.matinee.server.dto.MatineeUserDTO;
import com.matinee.server.service.MatineeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/matinee/api/v1/users")
public class MatineeUserController {

    @Autowired
    MatineeUserService matineeUserService;

    @Autowired
    MatineeUserConverter matineeUserConverter;

    @GetMapping("{id}")
    public ResponseEntity<MatineeResponse<MatineeUserDTO>> getUserById(@PathVariable UUID id){
        MatineeUser foundUser = matineeUserService.getMatineeUserById(id);
        MatineeUserDTO matineeUserResponse = matineeUserConverter.convertToDTO(foundUser);
        return ResponseEntity.ok(MatineeResponse.<MatineeUserDTO>builder()
                .result(matineeUserResponse).build());
    }

    @GetMapping
    public ResponseEntity<MatineeResponse<MatineeUserDTO>> getUserByUsername(@RequestParam String username){
        MatineeUser foundUser = matineeUserService.getMatineeUserByUserName(username);
        MatineeUserDTO matineeUserResponse = matineeUserConverter.convertToDTO(foundUser);
        return ResponseEntity.ok(MatineeResponse.<MatineeUserDTO>builder()
                .result(matineeUserResponse).build());

    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<MatineeUserDTO> addUser(@RequestBody MatineeUserDTO matineeUserDTO){

        // add validation
        MatineeUser matineeUserDomain =  matineeUserConverter.convertToEntity(matineeUserDTO);
        MatineeUser savedMatineeUserDomain = matineeUserService.addNewMatineeUser(matineeUserDomain);
        MatineeUserDTO matineeUserResponse = matineeUserConverter.convertToDTO(savedMatineeUserDomain);

        return new ResponseEntity<>(matineeUserResponse, HttpStatus.CREATED);
    }
}
