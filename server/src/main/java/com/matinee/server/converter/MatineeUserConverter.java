package com.matinee.server.converter;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.dto.MatineeUserDTO;
import org.springframework.stereotype.Component;

@Component
public class MatineeUserConverter {

    public MatineeUser convertToEntity(MatineeUserDTO matineeUserDTO){
        return MatineeUser.builder()
                .userId(matineeUserDTO.getId())
                .userName(matineeUserDTO.getUserName())
                .passwordHash(matineeUserDTO.getPasswordHash())
                .role(matineeUserDTO.getRole()).build();
    }

    public MatineeUserDTO convertToDTO(MatineeUser matineeUser){
        return MatineeUserDTO.builder()
                .id(matineeUser.getUserId())
                .userName(matineeUser.getUserName())
                .role(matineeUser.getRole()).build();
    }
}
