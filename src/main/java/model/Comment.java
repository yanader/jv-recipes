package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="comments")
public class Comment {

    @Id
    long commentId;

    String text;
    LocalDate datePosted;

    @ManyToOne(fetch = FetchType.LAZY)
    User author;

    @ManyToOne(fetch = FetchType.LAZY)
    Recipe associatedRecipe;
}
