package com.mycom.myapp.user.service;

import com.mycom.myapp.user.dto.User;
import com.mycom.myapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public User login(User user) {
        List<User> findUser = userRepository.findByUserEmail(user.getUserEmail());

        if (findUser.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        if (!findUser.get(0).getUserPassword().equals(user.getUserPassword())) {
            throw new IllegalStateException("비밀번호가 다릅니다.");
        }

        // 로그인 상태로 변경
        User loggedInUser = userRepository.findById(findUser.get(0).getId()).get();
        loggedInUser.setLoggedIn(true);

        return loggedInUser;
    }

    @Override
    public Long logout(Long userId) {
        // 로그아웃 상태로 변경
        User loggedOutUser = userRepository.findById(userId).get();
        loggedOutUser.setLoggedIn(false);

        return userId;
    }
}
