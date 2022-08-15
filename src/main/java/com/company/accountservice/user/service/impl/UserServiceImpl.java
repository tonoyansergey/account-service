package com.company.accountservice.user.service.impl;

import com.company.accountservice.user.dto.UserDto;
import com.company.accountservice.user.dto.UserResponseDto;
import com.company.accountservice.user.mapper.UserMapper;
import com.company.accountservice.user.repository.UserRepository;
import com.company.accountservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponseDto save(UserDto userDto) {
        return userMapper.toResponseDto(userRepository.save(userMapper.toEntity(userDto)));
    }
}
