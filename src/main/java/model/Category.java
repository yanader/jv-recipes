package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
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
