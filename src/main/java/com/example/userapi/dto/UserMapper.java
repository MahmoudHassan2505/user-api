package com.example.userapi.dto;

import com.example.userapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper    .class);
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
