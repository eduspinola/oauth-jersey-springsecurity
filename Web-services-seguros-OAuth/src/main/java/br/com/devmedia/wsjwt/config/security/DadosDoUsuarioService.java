package br.com.devmedia.wsjwt.config.security;

import br.com.devmedia.wsjwt.domain.Usuario;
import br.com.devmedia.wsjwt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DadosDoUsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioService.recuperarUsuarioPorLogin(username);

        if (usuario != null) {
            return new ResourceOwner(usuario);
        } else {
            throw new UsernameNotFoundException("Usuario não autorizado");
        }
    }

}
