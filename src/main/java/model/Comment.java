package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name ="comments")
public class Comment {

    @Id
    @GeneratedValue
    long commentId;
    @NotNull
    String text;
    LocalDate datePosted;

    @ManyToOne(fetch = FetchType.LAZY)
    User author;

    @ManyToOne(fetch = FetchType.LAZY)
    Recipe associatedRecipe;

    public Comment(String text, LocalDate datePosted, User author, Recipe associatedRecipe) {
        this.text = text;
        this.datePosted = datePosted;
        this.author = author;
        this.associatedRecipe = associatedRecipe;
    }
}
