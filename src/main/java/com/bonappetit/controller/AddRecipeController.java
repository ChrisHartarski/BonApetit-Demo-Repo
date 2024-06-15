package com.bonappetit.controller;

import com.bonappetit.model.dto.AddRecipeDTO;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AddRecipeController {
    private final RecipeService recipeService;
    private final UserService userService;

    public AddRecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @ModelAttribute("addRecipeData")
    public AddRecipeDTO addRecipeDTO() {
        return new AddRecipeDTO();
    }

    @GetMapping("/add-recipe")
    public String viewAddRecipe() {
        if(!userService.isUserLoggedIn()) {
            return "redirect:/";
        }
        return "recipe-add";
    }

    @PostMapping("/add-recipe")
    public String addRecipe(@Valid AddRecipeDTO addRecipeData,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        //validate dto
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRecipeData", addRecipeData);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRecipeData", bindingResult);
            return "redirect:/add-recipe";
        }

        //add recipe and redirect
        recipeService.addRecipe(addRecipeData);
        return "redirect:/home";
    }
}
