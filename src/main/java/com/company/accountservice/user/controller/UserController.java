package com.company.accountservice.user.controller;

import com.company.accountservice.user.dto.UserDto;
import com.company.accountservice.user.dto.UserResponseDto;
import com.company.accountservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
