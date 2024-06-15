package com.bonappetit.init;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.CategoryNameEnum;
import com.bonappetit.repo.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryInit implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private static final String MAIN_DISH_DESCRIPTION = "Heart of the meal, substantial and satisfying; main dish delights taste buds.";
    private static final String DESSERT_DESCRIPTION = "Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy.";
    private static final String COCKTAIL_DESCRIPTION = "Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.";

    public CategoryInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            initializeCategories();
        }
    }

    private void initializeCategories() {
        categoryRepository.saveAllAndFlush(List.of(
                new Category(CategoryNameEnum.MAIN_DISH, MAIN_DISH_DESCRIPTION),
                new Category(CategoryNameEnum.DESSERT, DESSERT_DESCRIPTION),
                new Category(CategoryNameEnum.COCKTAIL, COCKTAIL_DESCRIPTION)
        ));
    }
}
