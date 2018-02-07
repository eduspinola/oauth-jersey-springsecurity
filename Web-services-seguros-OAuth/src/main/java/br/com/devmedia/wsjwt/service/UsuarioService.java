package br.com.devmedia.wsjwt.service;

import br.com.devmedia.wsjwt.dao.UsuarioDAO;
import br.com.devmedia.wsjwt.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public Usuario recuperarUsuarioComLoginESenha(String usuario, String password) {
        return usuarioDAO.recuperarUsuarioPorUsernameEPassword(usuario, password);
    }

    public Usuario recuperarUsuarioPorLogin(String email) {
        return usuarioDAO.recuperarUsuarioPorLogin(email);
    }
}
