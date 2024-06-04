import jakarta.persistence.*;

@Entity
@Table(name="images")
class Image {

    @Id
    long imageId;
    String fileName;
    String fileData;
    @ManyToOne(fetch = FetchType.LAZY)
    Recipe associatedRecipe;
}
