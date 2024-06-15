package com.bonappetit.model.dto;

import com.bonappetit.model.entity.CategoryNameEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddRecipeDTO {
    @NotEmpty(message = "{recipe.name.notEmpty}")
    @Size(min = 2, max = 40, message = "{recipe.name.length}")
    private String name;
    @NotEmpty(message = "{recipe.ingredients.notEmpty}")
    @Size(min = 2, max = 80, message = "{recipe.ingredients.length}")
    private String ingredients;
    @NotNull(message = "{recipe.category.name.notEmpty}")
    private CategoryNameEnum categoryName;

    public AddRecipeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public CategoryNameEnum getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryNameEnum categoryName) {
        this.categoryName = categoryName;
    }
}
