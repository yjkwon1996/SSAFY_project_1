package com.mycom.myapp.user.controller;

import com.mycom.myapp.user.dto.User;
import com.mycom.myapp.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(
        // localhost:5500 과 127.0.0.1 구분
        origins = "http://localhost:8080", // allowCredentials = "true" 일 경우, orogins="*" 는 X
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<GetUsersResponse> findAllUsers() {
        List<User> users = userService.findAll();

        List<GetUsersResponse> response = new ArrayList<>();

        for(User user : users) {
            GetUsersResponse res = new GetUsersResponse();
            res.setId(user.getId());
            res.setLoggedIn(user.isLoggedIn());
            res.setUserEmail(user.getUserEmail());
            res.setUserName(user.getUserName());
            res.setUserRegisterDate(user.getUserRegisterDate());
            res.setAdmin(user.isAdmin());
            response.add(res);
        }

        return response;
    }

    @PostMapping("/api/users")
    public CreateUserResponse saveUser(@RequestBody @Valid CreateUserRequest request) {
        User user = new User();
        user.setUserEmail(request.getUserEmail());
        user.setUserPassword(request.getUserPassword());
        user.setUserName(request.getUserName());
        user.setUserRegisterDate(LocalDate.now());

        User retUserDto = userService.join(user);
        return new CreateUserResponse(retUserDto.getId());
    }

    @GetMapping("/api/users/page")
    public List<User> listStudent(int limit, int offset) {
        return userService.listUser(limit, offset);
    }
    
    @GetMapping("/api/users/count")
    public long countUser() {
        return userService.countUser();
    }

    @PutMapping("/api/users/{userId}")
    public UpdateUserResponse updateUser(@Valid UpdateUserRequest arequest, @PathVariable("userId") Long userId, MultipartHttpServletRequest request) throws IOException {
        User user = new User();
        user.setId(userId);
        user.setUserEmail(arequest.getUserEmail());
        user.setUserName(arequest.getUserName());

        User retUser = userService.update(user, request);
        return new UpdateUserResponse(retUser.getId(), retUser.getUserProfileImageUrl());
    }

    @DeleteMapping("/api/users/{userId}")
    public DeleteUserResponse deleteUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
        return new DeleteUserResponse(userId);
    }

    @Data
    static class GetUsersResponse {
        private Long id;
        private boolean isLoggedIn;
        private String userEmail;
        private String userName;
        private LocalDate userRegisterDate;
        private boolean isAdmin;
    }

    @Data
    @AllArgsConstructor
    static class DeleteUserResponse {
        private Long id;
    }

    @Data
    static class UpdateUserRequest {
        @NotEmpty
        private String userEmail;
        @NotEmpty
        private String userName;
    }

    @Data
    @AllArgsConstructor
    static class UpdateUserResponse {
        private Long id;
        private String userProfileImageUrl;
    }

    @Data
    static class CreateUserRequest {
        @NotEmpty
        private String userEmail;
        @NotEmpty
        private String userPassword;
        @NotEmpty
        private String userName;
    }

    @Data
    @AllArgsConstructor
    static class CreateUserResponse {
        private Long id;
    }
}
