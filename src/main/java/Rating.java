import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="ratings")
public class Rating {

    @Id
    long ratingID;
    int ratingOutOfFive;
    LocalDate dateRated;

    @ManyToOne(fetch = FetchType.LAZY)
    Recipe associatedRecipe;

    @ManyToOne(fetch = FetchType.LAZY)
    User rater;


}
