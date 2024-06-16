package com.bonappetit.model.dto;

import com.bonappetit.model.entity.CategoryNameEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllRecipesDTO {
    private final List<RecipeDetailsDTO> allRecipes;

    public AllRecipesDTO() {
        this.allRecipes = new ArrayList<>();
    }
    public AllRecipesDTO(List<RecipeDetailsDTO> allRecipes) {
        this.allRecipes = allRecipes;
    }

    public List<RecipeDetailsDTO> getAllRecipes() {
        return allRecipes;
    }

    public long getCount() {
        return allRecipes.size();
    }

//    public long getMainDishCount() {
//        return allRecipes.stream()
//                .filter(r -> r.getCategoryName().equals(CategoryNameEnum.MAIN_DISH))
//                .count();
//    }
//
//    public long getDessertCount() {
//        return allRecipes.stream()
//                .filter(r -> r.getCategoryName().equals(CategoryNameEnum.DESSERT))
//                .count();
//    }
//
//    public long getCocktailCount() {
//        return allRecipes.stream()
//                .filter(r -> r.getCategoryName().equals(CategoryNameEnum.COCKTAIL))
//                .count();
//    }

    public List<RecipeDetailsDTO> getAllMainDishes() {
        return allRecipes.stream()
                .filter(r -> r.getCategoryName().equals(CategoryNameEnum.MAIN_DISH))
                .collect(Collectors.toList());
    }

    public List<RecipeDetailsDTO> getAllDesserts() {
        return allRecipes.stream()
                .filter(r -> r.getCategoryName().equals(CategoryNameEnum.DESSERT))
                .collect(Collectors.toList());
    }

    public List<RecipeDetailsDTO> getAllCocktails() {
        return allRecipes.stream()
                .filter(r -> r.getCategoryName().equals(CategoryNameEnum.COCKTAIL))
                .collect(Collectors.toList());
    }
}
