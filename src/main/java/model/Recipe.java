package model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    User creator;

    @OneToMany(mappedBy="ingredientId")
    List<Ingredient> ingredientList;

    @OneToMany(mappedBy="categoryId")
    List<Category> categoryList;

    LocalDate created;
    LocalDate lastModified;

    public Recipe(String title, User creator) {
        this.title = title;
        this.creator = creator;
        this.ingredientList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
    }
}
