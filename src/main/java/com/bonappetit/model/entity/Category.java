package com.bonappetit.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "category_name", nullable = false, unique = true)
    private CategoryNameEnum categoryName;
    @Column
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Recipe> recipes;

    public Category() {
        this.recipes = new HashSet<>();
    }

    public Category(CategoryNameEnum categoryName, String description) {
        super();
        this.categoryName = categoryName;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryNameEnum getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryNameEnum categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
