package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="images")
public class Image {

    @Id
    @GeneratedValue
    long imageId;
    String fileName;
    String fileData;
    @ManyToOne(fetch = FetchType.LAZY)
    Recipe associatedRecipe;

    public Image(String fileName, String fileData, Recipe associatedRecipe) {
        this.fileName = fileName;
        this.fileData = fileData;
        this.associatedRecipe = associatedRecipe;
    }
}
