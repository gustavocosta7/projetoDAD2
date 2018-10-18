/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.GenericDao;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Cliente;
import modelo.Compra;
import modelo.FormaPagamento;
import modelo.ICarrinhoService;
import modelo.Item;

/**
 *
 * @author Suporte
 */

@Remote(ICarrinhoService.class)
@Stateful
public class CarrinhoService implements ICarrinhoService{
    
    @PersistenceContext
    private EntityManager em;
    
    
    private Compra compra = new Compra();

    @Override
    public void inserir(Item item) {
        this.compra.getItens().add(item);
    }

    @Override
    public void remover(Item item) {
        this.compra.getItens().remove(item);
    }

    @Override
    public List<Item> listar() {
        return (List<Item>)compra.getItens();
    }

    @Override
    public void insereFormaPagamento(FormaPagamento fp) {
        this.compra.setForma(fp);
    }

    @Override
    public void insereCliente(Cliente cliente) {
        this.compra.setCliente(cliente);
    }

    @Override
    public boolean salvaCompra() {
        GenericDao<Compra> dao = new GenericDao(em);
        dao.save(compra);
        return true;
    
    }
    
    
    
    
}
