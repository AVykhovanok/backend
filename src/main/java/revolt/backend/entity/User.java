package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotNull
    @Column(name = "login", unique = true, length = 50, nullable = false)
    String login;

    @NotNull
    @Column(name = "password", length = 65, nullable = false)
    String password;

    @NotNull
    @Column(name = "first_name", length = 25, nullable = false)
    String firstName;

    @NotNull
    @Column(name = "last_name", length = 25, nullable = false)
    String lastName;

    @NotNull
    @Column(name = "email", length = 50, nullable = false)
    String email;

    @NotNull
    @Column(name = "about")
    String about;

    @NotNull
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    Role role;
}