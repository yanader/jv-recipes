package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tags")
public class Tag {

    @Id
    @GeneratedValue
    long tagId;
    @NotNull
    String name;

    public Tag(String name) {
        this.name = name;
    }
}
