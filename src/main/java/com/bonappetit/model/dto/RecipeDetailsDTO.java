package com.bonappetit.model.dto;

import com.bonappetit.model.entity.CategoryNameEnum;

public class RecipeDetailsDTO {
    private long id;
    private String name;
    private String ingredients;
    private CategoryNameEnum categoryName;

    public RecipeDetailsDTO() {
    }

    public RecipeDetailsDTO(CategoryNameEnum categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
