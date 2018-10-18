/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Suporte
 */
@Entity
public class Compra {
    @Id
    private long id;
    private double desconto;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private FormaPagamento forma;
    @OneToMany
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
