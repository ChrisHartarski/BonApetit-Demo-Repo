package com.bonappetit.service;

import com.bonappetit.model.dto.RegisterUserDTO;

public interface UserService {
    boolean usernameExists(String username);
    boolean emailExists(String email);
    void registerUser(RegisterUserDTO registerData);
}
