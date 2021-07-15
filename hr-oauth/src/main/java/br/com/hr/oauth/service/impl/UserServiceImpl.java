package br.com.hr.oauth.service.impl;

import br.com.hr.oauth.clients.UserClient;
import br.com.hr.oauth.entities.User;
import br.com.hr.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserClient userClient;

    @Override
    public User findUserByEmail(String email) {
        User user = userClient.findByEmail(email).getBody();
        if(Objects.isNull(user)){
            throw new IllegalArgumentException("Email not found");
        }
        return user;
    }
}
