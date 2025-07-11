package co.com.api.divisub.service;

import co.com.api.divisub.entity.Usuario;
import co.com.api.divisub.excepciones.FoundUserException;
import co.com.api.divisub.repository.UsuarioRepository;
import co.com.api.divisub.request.RegistroUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(RegistroUserRequest registroUserRequest) {
        usuarioRepository.findByEmail(registroUserRequest.getEmail())
                .ifPresent(u -> { throw new FoundUserException(registroUserRequest.getEmail()); });

        Usuario nuevoUsuario = mapToUsuario(registroUserRequest);
        return usuarioRepository.save(nuevoUsuario);
    }

    private Usuario mapToUsuario(RegistroUserRequest request) {
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getContrasena()));
        usuario.setNombre(request.getNombre());
        return usuario;
    }
}
