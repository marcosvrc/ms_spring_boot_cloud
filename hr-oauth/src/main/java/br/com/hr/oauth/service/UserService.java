package br.com.hr.oauth.service;

import br.com.hr.oauth.entities.User;

public interface UserService {

    public User findUserByEmail(String email);
}
