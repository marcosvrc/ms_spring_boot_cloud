package br.com.hruser.services;

import br.com.hruser.entities.User;

public interface UserService {

    public User findByEmail(String email);

    public User findById(Long id);
}
