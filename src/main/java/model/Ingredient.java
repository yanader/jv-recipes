package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    long ingredientId;
    String name;
    int quantity;
    String unitOfMeasurement;
}
