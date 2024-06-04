package model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
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
}
