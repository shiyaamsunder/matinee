package com.matinee.server.mapper;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.dto.MatineeUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatineeUserMapper {
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    MatineeUser convertToEntity(MatineeUserDTO matineeUserDTO);


    MatineeUserDTO convertToDTO(MatineeUser matineeUser);
}
