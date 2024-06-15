package com.bonappetit.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUserDTO {
    @NotEmpty(message = "{username.notEmpty}")
    @Size(min = 3, max = 20, message = "{username.length}")
    private String username;
    @NotEmpty(message = "{password.notEmpty}")
    @Size(min = 3, max = 20, message = "{password.length}")
    private String password;

    public LoginUserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
