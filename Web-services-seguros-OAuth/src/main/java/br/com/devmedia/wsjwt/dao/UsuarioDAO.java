package br.com.devmedia.wsjwt.dao;

import br.com.devmedia.wsjwt.domain.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    public Usuario recuperarUsuarioPorUsernameEPassword(String username, String password) {
        //EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password", Usuario.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Usuario salvarUsuario(Usuario usuario) {
        //EntityManager em = JPAUtil.getEntityManager();

        //try {
        //    em.getTransaction().begin();
            em.persist(usuario);
        //    em.getTransaction().commit();
        //} finally {
        //    em.close();
        //}
        return usuario;
    }

    public Usuario recuperarUsuarioPorLogin(String username) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
