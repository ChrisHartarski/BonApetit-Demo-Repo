package com.bonappetit.service;

import com.bonappetit.model.dto.AddRecipeDTO;
import com.bonappetit.model.dto.RecipeDetailsDTO;

import java.util.List;

public interface RecipeService {
    void addRecipe(AddRecipeDTO addRecipeData);
    List<RecipeDetailsDTO> getAllRecipes();
    void deleteRecipe(long id);
}
