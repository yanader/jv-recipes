package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    long userId;
    @NotNull
    String username;
    String email;
    String password;
    List<String> roles;
    LocalDate dateRegistered;

    public User(String username, String email, String password, LocalDate dateRegistered) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = new ArrayList<>();
        this.dateRegistered = dateRegistered;
    }
}
