package co.com.api.divisub.controller;

import co.com.api.divisub.entity.Usuario;
import co.com.api.divisub.request.RegistroUserRequest;
import co.com.api.divisub.service.RegistroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final RegistroUsuarioService registroUsuarioService;

    @Autowired
    public RegistroController(RegistroUsuarioService registroUsuarioService) {
        this.registroUsuarioService = registroUsuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@Validated @RequestBody RegistroUserRequest request) {
        Usuario nuevoUsuario = registroUsuarioService.registrarUsuario(request);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
