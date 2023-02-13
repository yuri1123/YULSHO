package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.Repository.UserRepository;
import com.yuri.shoppingsite.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String password, String email, String nickname, String birth, String phone){
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setNickname(nickname);
        user.setBirth(birth);
        user.setPhone(phone);
        this.userRepository.save(user);
        return user;
    }

}
