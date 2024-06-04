package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
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
}
