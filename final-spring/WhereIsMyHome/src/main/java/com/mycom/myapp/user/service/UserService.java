package com.mycom.myapp.user.service;

import com.mycom.myapp.user.dto.User;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public User join(User user);
    public User update(User user, MultipartHttpServletRequest request) throws IOException;
    public void delete(Long id);
    public List<User> findAll();

    public List<User> listUser(int limit, int pageUnit);
    public long countUser();
}
