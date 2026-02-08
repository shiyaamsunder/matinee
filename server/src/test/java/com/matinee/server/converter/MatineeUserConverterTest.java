package com.matinee.server.converter;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.dto.MatineeUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MatineeUserConverterTest {


    @InjectMocks
    MatineeUserConverter matineeUserConverter;

    MatineeUser matineeUser;

    MatineeUserDTO matineeUserDTO;


    @BeforeEach
    void setup(){
        this.matineeUser = MatineeUser.builder()
                .userId(UUID.fromString("0f3fcaf1-cd2e-4047-afe7-5785d3d6d12e"))
                .userName("admin")
                .role("admin")
                .build();

        this.matineeUserDTO = MatineeUserDTO.builder().id(UUID.fromString("0f3fcaf1-cd2e-4047-afe7-5785d3d6d12e"))
                .userName("admin")
                .role("admin")
                .build();
    }

    @Test
    public void test_convertToEntity(){
        MatineeUser matineeUserEntity = matineeUserConverter.convertToEntity(this.matineeUserDTO);

        assertNotNull(matineeUserEntity);
        assertEquals(matineeUserEntity.getUserId(), this.matineeUserDTO.getId());
        assertEquals(matineeUserEntity.getUserName(), this.matineeUserDTO.getUserName());
        assertEquals(matineeUserEntity.getRole(), this.matineeUserDTO.getRole());

    }

    @Test
    public void test_convertToDTO(){
        MatineeUserDTO mtUserDTO = matineeUserConverter.convertToDTO(this.matineeUser);

        assertNotNull(mtUserDTO);
        assertEquals(mtUserDTO.getId(), this.matineeUser.getUserId());
        assertEquals(mtUserDTO.getUserName(), this.matineeUser.getUserName());
        assertEquals(mtUserDTO.getRole(), this.matineeUser.getRole());
    }
}
