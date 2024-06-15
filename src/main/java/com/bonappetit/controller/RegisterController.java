package com.bonappetit.controller;

import com.bonappetit.model.dto.RegisterUserDTO;
import com.bonappetit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerData")
    public RegisterUserDTO registerData(){
        return new RegisterUserDTO();
    }

    @GetMapping("/register")
    public String viewRegister() {
        if(userService.isUserLoggedIn()) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid RegisterUserDTO registerData,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        //validate dto
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", registerData);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);
            return "redirect:/register";
        }

        //validate existing user
        if (userService.usernameExists(registerData.getUsername())) {
            redirectAttributes.addFlashAttribute("registerData", registerData);
            redirectAttributes.addFlashAttribute("usernameExists", true);
            return "redirect:/register";
        }

        //validate existing email
        if (userService.emailExists(registerData.getEmail())) {
            redirectAttributes.addFlashAttribute("registerData", registerData);
            redirectAttributes.addFlashAttribute("emailExists", true);
            return "redirect:/register";
        }

        //register user and redirect
        userService.registerUser(registerData);
        return "redirect:/login";
    }
}
