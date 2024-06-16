package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.AllRecipesDTO;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    private final UserService userService;
    private final RecipeService recipeService;
    private final UserSession userSession;

    public HomeController(UserService userService, RecipeService recipeService, UserSession userSession) {
        this.userService = userService;
        this.recipeService = recipeService;
        this.userSession = userSession;
    }

    @ModelAttribute("allRecipes")
    public AllRecipesDTO allRecipesDTO() {
        return new AllRecipesDTO(recipeService.getAllRecipes());
    }

    @ModelAttribute("favouriveRecipes")
    public Set<Recipe> favouriteRecipes() {
        if(userService.isUserLoggedIn()) {
            return userService.getLoggedUser().getFavouriteRecipes();
        }
        return new HashSet<>();
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

    @PostMapping("/home/{id}")
    public String addRecipeToFavourites(@PathVariable long id) {
        userService.addRecipeToFavourites(id);
        return "redirect:/home";
    }

    @DeleteMapping("/home/remove-{id}")
    public String removeRecipe(@PathVariable long id) {
        recipeService.deleteRecipe(id);
        return "redirect:/home";
    }

    @DeleteMapping("/home/remove-favourite-{id}")
    public String removeRecipeFromFavourites(@PathVariable long id) {
        userService.removeRecipeFromFavourites(userSession.getId(), id);
        return "redirect:/home";
    }
}
