package co.com.api.divisub.security;

import co.com.api.divisub.entity.Usuario;
import co.com.api.divisub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(userEmail);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email: " + userEmail);
        }
        // Usuario simulado
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles("USER", "ADMIN") // Asignar roles según sea necesario
                .build();
    }
}
