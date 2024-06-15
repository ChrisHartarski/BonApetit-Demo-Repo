package com.bonappetit.config;

import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class UserSession {
    private long id;
    private String username;
    private Set<Recipe> favouriteRecipes;

    public UserSession() {
    }

    public void logout() {
        this.id = 0;
        this.username = "";
        this.favouriteRecipes = new HashSet<>();
    }

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.favouriteRecipes = user.getFavouriteRecipes();
    }

    public boolean isUserLoggedIn() {
        return id != 0;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<Recipe> getFavouriteRecipes() {
        return favouriteRecipes;
    }
}
