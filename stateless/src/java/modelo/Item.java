/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Suporte
 */
@Entity
public class Item implements Serializable{
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue
    private int id;
    private Produto produto;
    private int quantidade;

    public Item(Produto produto, int qtd) {
        this.produto = produto;
        this.quantidade = qtd;
    }

    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

   


    public double getTotalItem() {
        return produto.getValor() * quantidade;
        }

    
}
