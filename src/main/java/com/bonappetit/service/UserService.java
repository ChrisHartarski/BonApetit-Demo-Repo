package com.bonappetit.service;

import com.bonappetit.model.dto.LoginUserDTO;
import com.bonappetit.model.dto.RecipeDetailsDTO;
import com.bonappetit.model.dto.RegisterUserDTO;
import com.bonappetit.model.entity.User;

public interface UserService {
    boolean usernameExists(String username);
    boolean emailExists(String email);
    void registerUser(RegisterUserDTO registerData);
    boolean userCorrect(LoginUserDTO loginUserDTO);
    void loginUser(LoginUserDTO loginData);
    void logoutUser();
    boolean isUserLoggedIn();
    User getLoggedUser();
    void addRecipeToFavourites(long id);
    void removeRecipeFromFavourites(long userId, long recipeId);
    void removeRecipeFromAllFavourites(long recipeId);
}
