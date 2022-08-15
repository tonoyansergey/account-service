package com.company.accountservice.user.mapper;

import com.company.accountservice.user.dto.UserDto;
import com.company.accountservice.user.dto.UserResponseDto;
import com.company.accountservice.user.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
    UserResponseDto toResponseDto(User user);
}
