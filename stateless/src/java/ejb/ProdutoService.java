/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.GenericDao;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Categoria;
import modelo.IProdutoService;
import modelo.Produto;

/**
 *
 * @author gustav0
 */
@Stateless
@Remote(IProdutoService.class)
public class ProdutoService implements IProdutoService{
    
    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void inserir(Produto p) {
        GenericDao<Produto> dao = new GenericDao<Produto>(em);
        dao.save(p);
    }

    @Override
    public List<Produto> listar() {
        GenericDao<Produto> dao = new GenericDao<Produto>(em);
        return dao.findAll(Produto.class);
    }

    @Override
    public void remover(Produto p) {
        GenericDao<Produto> dao = new GenericDao<Produto>(em);
        dao.remove(Produto.class, p.getCodigo());
    }

    @Override
    public Produto getProduto(Produto p) {
        GenericDao<Produto> dao = new GenericDao<Produto>(em);
        return dao.findById(Produto.class, p.getCodigo());
    }

    @Override
    public List<Categoria> listarCategoria() {
        GenericDao<Categoria> dao = new GenericDao<Categoria>(em);
        return dao.findAll(Categoria.class);
    }
    
}
