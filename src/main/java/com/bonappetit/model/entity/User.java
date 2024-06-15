package com.bonappetit.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "added_by")
    private Set<Recipe> addedRecipes;
    @OneToMany(mappedBy = "added_by")
    private Set<Recipe> favouriteRecipes;

    public User() {
        this.addedRecipes = new HashSet<>();
        this.favouriteRecipes = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Recipe> getAddedRecipes() {
        return addedRecipes;
    }

    public void setAddedRecipes(Set<Recipe> addedRecipes) {
        this.addedRecipes = addedRecipes;
    }

    public Set<Recipe> getFavouriteRecipes() {
        return favouriteRecipes;
    }

    public void setFavouriteRecipes(Set<Recipe> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
    }
}
