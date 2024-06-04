package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
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
}
