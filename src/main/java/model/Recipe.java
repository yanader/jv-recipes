package model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue
    long recipeId;

    @NotNull
    String title;
    String description;
    String instructions;
    int preparationTime;
    int cookingTime;
    int servings;
    String difficulty;

    @OneToMany(mappedBy="ratingID")
    List<Rating> ratings;

    @ManyToOne(fetch = FetchType.LAZY)
    User creator;

    @OneToMany(mappedBy="ingredientId")
    List<Ingredient> ingredientList;

    @OneToMany(mappedBy="categoryId")
    List<Category> categoryList;

    LocalDate created;
    LocalDate lastModified;

    public Recipe(String title, String description, String instructions, int preparationTime, int cookingTime, int servings, String difficulty, User creator, LocalDate created, LocalDate lastModified) {
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.servings = servings;
        this.difficulty = difficulty;
        this.ratings = new ArrayList<>();
        this.creator = creator;
        this.ingredientList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
        this.created = created;
        this.lastModified = lastModified;
    }
}
