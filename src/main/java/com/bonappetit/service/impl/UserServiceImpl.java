package com.bonappetit.service.impl;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.LoginUserDTO;
import com.bonappetit.model.dto.RegisterUserDTO;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.UserRepository;
import com.bonappetit.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void registerUser(RegisterUserDTO registerData) {
        User user = modelMapper.map(registerData, User.class);
        user.setPassword(passwordEncoder.encode(registerData.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public boolean userCorrect(LoginUserDTO loginUserDTO) {
        return userRepository.getUserByUsername(loginUserDTO.getUsername())
                .filter(u -> passwordEncoder.matches(loginUserDTO.getPassword(), u.getPassword()))
                .isPresent();
    }

    @Override
    public void loginUser(LoginUserDTO loginData) {
        User user = userRepository.getUserByUsername(loginData.getUsername()).get();
        userSession.login(user);
    }

    @Override
    public void logoutUser() {
        userSession.logout();
    }

    @Override
    public boolean isUserLoggedIn() {
        return userSession.isUserLoggedIn();
    }

    @Override
    public User getLoggedUser() {
        return userRepository.getUserById(userSession.getId()).orElse(null);
    }


}
