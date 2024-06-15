package com.bonappetit.controller;

import com.bonappetit.model.dto.LoginUserDTO;
import com.bonappetit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginLogoutController {
    private final UserService userService;

    public LoginLogoutController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("loginData")
    public LoginUserDTO loginUserDTO() {
        return new LoginUserDTO();
    }

    @GetMapping("/login")
    public String viewLogin() {
        if(userService.isUserLoggedIn()) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid LoginUserDTO loginData,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        //validate dto
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginData", loginData);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData", bindingResult);
            return "redirect:/login";
        }

        //validate username and password
        if (!userService.userCorrect(loginData)) {
            redirectAttributes.addFlashAttribute("loginData", loginData);
            redirectAttributes.addFlashAttribute("wrongUsernameOrPassword", true);
            return "redirect:/login";
        }

        //login user and redirect to home
        userService.loginUser(loginData);
        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }
}
