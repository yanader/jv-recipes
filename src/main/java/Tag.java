import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tags")
class Tag {

    @Id
    long tagId;

    String name;
}
