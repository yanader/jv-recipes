package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tags")
public class Tag {

    @Id
    long tagId;

    String name;
}
