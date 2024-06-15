package com.bonappetit.service.impl;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.CategoryNameEnum;
import com.bonappetit.repo.CategoryRepository;
import com.bonappetit.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryByName(CategoryNameEnum categoryName) {
        return categoryRepository.getCategoriesByCategoryName(categoryName).orElse(null);
    }
}
