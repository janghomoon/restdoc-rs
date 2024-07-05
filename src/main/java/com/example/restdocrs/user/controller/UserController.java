package com.example.restdocrs.user.controller;

import com.example.restdocrs.user.UserService;
import com.example.restdocrs.user.dto.request.UserInfoRequest;
import com.example.restdocrs.user.dto.response.UserInfoResponse;
import javax.validation.Valid;
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

    @PostMapping("/list")
    public ResponseEntity<UserInfoResponse> getUserInfoList(@RequestBody @Valid UserInfoRequest request) {
        return ResponseEntity.ok(userService.getUserInfoList(request));
    }

}
