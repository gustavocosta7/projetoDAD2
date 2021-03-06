/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Suporte
 */
public class Compra implements Serializable{
    private long id;
    private double desconto;
    private Cliente cliente;
    private FormaPagamento forma;
    private Collection<Item> itens;

    public Collection<Item> getItens() {
        return itens;
    }

    public void setItens(Collection<Item> itens) {
        this.itens = itens;
    }
    

    public Compra(double desconto, Cliente cliente, FormaPagamento forma, Collection<Item> itens) {
        this.desconto = desconto;
        this.cliente = cliente;
        this.forma = forma;
        this.itens = itens;
    }

    
    
    public Compra() {
    
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }
    
    
    
    
    
}
