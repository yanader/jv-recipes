package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
