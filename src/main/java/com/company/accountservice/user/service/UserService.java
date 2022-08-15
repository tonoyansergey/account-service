package com.company.accountservice.user.service;

import com.company.accountservice.user.dto.UserDto;
import com.company.accountservice.user.dto.UserResponseDto;

public interface UserService {

    UserResponseDto save(UserDto userDto);
}
