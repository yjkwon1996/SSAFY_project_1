package com.mycom.myapp.user.controller;

import com.mycom.myapp.user.dto.User;
import com.mycom.myapp.user.service.LoginService;
import com.mycom.myapp.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@CrossOrigin(
        // localhost:5500 과 127.0.0.1 구분
        origins = "http://localhost:8080", // allowCredentials = "true" 일 경우, orogins="*" 는 X
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/api/login")
    public LoginUserResponse loginUser(@RequestBody @Valid LoginUserRequest request, HttpSession session) {
        User user = new User();
        user.setUserEmail(request.getUserEmail());
        user.setUserPassword(request.getUserPassword());

        User retUser = loginService.login(user);
        System.out.println(retUser.getId());
        if (retUser != null) session.setAttribute("userDto", retUser);
        System.out.println(retUser.getUserProfileImageUrl());
        return new LoginUserResponse(retUser.getId(), retUser.getUserName(), retUser.getUserEmail(), retUser.getUserRegisterDate(), retUser.getUserProfileImageUrl(), retUser.isAdmin());
    }

    @GetMapping("/api/logout/{userId}")
    public LogoutUserResponse logoutUser(@PathVariable("userId") Long userId, HttpSession session) {
        Long retId = loginService.logout(userId);
        session.invalidate();
        return new LogoutUserResponse(retId);
    }

    @Data
    static class LoginUserRequest {
        private String userEmail;
        private String userPassword;
    }

    @Data
    @AllArgsConstructor
    static class LoginUserResponse {
        private Long id;
        private String userName;
        private String userEmail;
        private LocalDate userRegisterDate;
        private String userProfileImageUrl;
        private boolean isAdmin;
    }

    @Data
    @AllArgsConstructor
    static class LogoutUserResponse {
        private Long id;
    }
}