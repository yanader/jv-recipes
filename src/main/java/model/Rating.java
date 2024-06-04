package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="ratings")
public class Rating {

    @Id
    @GeneratedValue
    long ratingID;
    int ratingOutOfFive;
    LocalDate dateRated;

    @ManyToOne(fetch = FetchType.LAZY)
    Recipe associatedRecipe;

    @ManyToOne(fetch = FetchType.LAZY)
    User rater;

    public Rating(int ratingOutOfFive, LocalDate dateRated, Recipe associatedRecipe, User rater) {
        this.ratingOutOfFive = ratingOutOfFive;
        this.dateRated = dateRated;
        this.associatedRecipe = associatedRecipe;
        this.rater = rater;
    }
}
