package com.mycom.myapp.user.service;

import com.mycom.myapp.user.dto.User;

public interface LoginService {

    public User login(User user);
    public Long logout(Long userId);
}
