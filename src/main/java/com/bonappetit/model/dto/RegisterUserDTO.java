package com.bonappetit.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterUserDTO {
    @NotEmpty(message = "{username.notEmpty}")
    @Size(min = 3, max = 20, message = "{username.length}")
    private String username;
    @NotEmpty(message = "{email.notEmpty}")
    @Email(message = "{email.invalid}")
    private String email;
    @NotEmpty(message = "{password.notEmpty}")
    @Size(min = 3, max = 20, message = "{password.length}")
    private String password;
    @NotEmpty(message = "{password.notEmpty}")
    @Size(min = 3, max = 20, message = "{password.length}")
    private String confirmPassword;

    public RegisterUserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
