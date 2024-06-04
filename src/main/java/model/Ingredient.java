package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue
    long ingredientId;
    @NotNull
    String name;
    int quantity;
    String unitOfMeasurement;
}
