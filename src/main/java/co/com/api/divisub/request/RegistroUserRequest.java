package co.com.api.divisub.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroUserRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @NotBlank
    @NotNull(message = "La contraseña no puede estar vacía")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número")
    private String contrasena;
}
