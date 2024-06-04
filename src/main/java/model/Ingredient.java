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

    public Ingredient(String name, int quantity, String unitOfMeasurement) {
        this.name = name;
        this.quantity = quantity;
        this.unitOfMeasurement = unitOfMeasurement;
    }
}
