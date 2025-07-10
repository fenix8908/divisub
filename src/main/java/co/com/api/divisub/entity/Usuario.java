package co.com.api.divisub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    private String nombre;

    @Column(unique = true, name = "email")
    private String email;
    @Column(name = "contraseña_hash")
    private String password;

    private LocalDateTime fechaRegistro = LocalDateTime.now();
}
