package com.bonappetit.service.impl;

import com.bonappetit.model.dto.AddRecipeDTO;
import com.bonappetit.model.dto.RecipeDetailsDTO;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.service.CategoryService;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addRecipe(AddRecipeDTO addRecipeData) {
        Recipe recipe = modelMapper.map(addRecipeData, Recipe.class);
        recipe.setCategory(categoryService.getCategoryByName(addRecipeData.getCategoryName()));
        recipe.setAddedBy(userService.getLoggedUser());
        recipeRepository.saveAndFlush(recipe);
    }

    @Override
    public List<RecipeDetailsDTO> getAllRecipes() {
        return recipeRepository.getAllBy().stream()
                .map(r -> modelMapper.map(r, RecipeDetailsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRecipe(long id) {
        userService.removeRecipeFromAllFavourites(id);
        recipeRepository.deleteById(id);
    }
}
