package com.bonappetit.controller;

import com.bonappetit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String viewIndex() {
        if(userService.isUserLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String viewHome() {
        if(!userService.isUserLoggedIn()) {
            return "redirect:/";
        }
        return "home";
    }
}
