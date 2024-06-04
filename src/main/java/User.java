import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    long userId;
    String username;
    String email;
    String password;
    List<String> roles;
    LocalDate dateRegistered;
}
