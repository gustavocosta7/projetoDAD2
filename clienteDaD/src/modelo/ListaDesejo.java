/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Collection;

/**
 *
 * @author gustav0
 */
public class ListaDesejo {
    private long id;
    private String nome;
    private String email;
    private Collection<Produto> produtos;

    public ListaDesejo(String nome, String email, Collection<Produto> produtos) {
        this.nome = nome;
        this.email = email;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
