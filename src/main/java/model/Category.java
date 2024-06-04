package model;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue
    long categoryId;
    String name;

    public Category(String name) {
        this.name = name;
    }
}
