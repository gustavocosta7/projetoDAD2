/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Suporte
 */

public interface ICarrinhoService{
/**
 * 
 * @param item 
 */    
    public void inserir(Item item);
    public void remover(Item item);
    public List<Item> listar();
    
   /**
    * Novas funções
    */ 
    public void insereFormaPagamento(FormaPagamento fp);
    public void insereCliente(Cliente cliente);
    
    /**
     * Persistencia de banco
     * 
     */
    
    public boolean salvaCompra();
}
