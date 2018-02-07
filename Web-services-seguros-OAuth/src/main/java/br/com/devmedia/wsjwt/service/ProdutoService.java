package br.com.devmedia.wsjwt.service;

import br.com.devmedia.wsjwt.dao.ProdutoDAO;
import br.com.devmedia.wsjwt.domain.Produto;
import br.com.devmedia.wsjwt.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private MarcaService marcaService;

    public void salvarProduto(Produto produto, long marcaId) {
        produto.setMarca(marcaService.recuperarMarcaPorId(IdUtils.idValido(marcaId)));
        produtoDAO.salvarProduto(produto);
    }

    public List<Produto> recuperarProdutos(long marcaId) {
        return produtoDAO.recuperarProdutos(IdUtils.idValido(marcaId));
    }

    public Produto recuperarProdutoPorId(long marcaId, long produtoId) {
        //EntityManager em = JPAUtil.getEntityManager();
        //try {
        //em.getTransaction().begin();
        Produto produto = produtoDAO.recuperarProdutoPorId(IdUtils.idValido(marcaId), IdUtils.idValido(produtoId));//, em);
        //em.getTransaction().commit();
        //} finally {
        //    em.close();
        //}
        return produto;
    }

    public List<Produto> recuperarProdutosPorNome(long marcaId, String nome) {
        return produtoDAO.recuperarProdutosPorNome(IdUtils.idValido(marcaId), nome);
    }

    public void atualizarProduto(long marcaId, long produtoId, Produto produto) {
        //EntityManager em = JPAUtil.getEntityManager();

        //em.getTransaction().begin();
        produto.setId(produtoId);
        produtoDAO.recuperarProdutoPorId(IdUtils.idValido(marcaId), IdUtils.idValido(produtoId));//, em);
        produtoDAO.atualizarProduto(produto);//, em);
        //em.getTransaction().commit();
    }

    public void excluirProduto(long produtoId) {
        produtoDAO.excluirProduto(IdUtils.idValido(produtoId));
    }

   /* public void darLike(long autorId, long cursoId) {
        //EntityManager em = JPAUtil.getEntityManager();

        //try {
        //    em.getTransaction().begin();
        Produto curso = produtoDAO.recuperarProdutoPorId(autorId, cursoId);//, em);
            curso.setLikes(curso.getLikes() + 1);
        //    em.getTransaction().commit();
        //} finally {
        //    em.close();
        //}
    }

    public void removerLike(long autorId, long cursoId) {
        //EntityManager em = JPAUtil.getEntityManager();

        //try {
        //    em.getTransaction().begin();
        Produto curso = produtoDAO.recuperarCursoPorId(autorId, cursoId);//, em);
            if (curso.getLikes() > 0) {
                curso.setLikes(curso.getLikes() - 1);
            }
        //    em.getTransaction().commit();
        //} finally {
        //    em.close();
        //}
    }
*/
    /*public Produto publicarDespublicarProduto(long marcaId, long produtoId, Boolean status) {
        EntityManager em = JPAUtil.getEntityManager();
        Produto produto;

        //try {
        em.getTransaction().begin();
        produto = produtoDAO.recuperarProdutoPorId(marcaId, produtoId, em);
        produto.setPublicado(status);
        em.getTransaction().commit();
        //} finally {
        //    em.close();
        //}
        return produto;
    }*/
}
