package com.bonappetit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddRecipeController {

    @GetMapping("/add-recipe")
    public String viewAddRecipe() {
        return "recipe-add";
    }
}
