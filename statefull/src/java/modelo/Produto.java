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
import javax.persistence.ManyToOne;

/**
 *
 * @author Suporte
 */
@Entity
public class Produto implements Serializable{
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue
    private long codigo;
    private String nome;
    private double valor;
//MANY TO ONE 
    @ManyToOne
    private Categoria categoria;

    public Produto() {
    }


    
    public Produto(int codigo, String nome, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }
    
    
    public Produto(String nome, double valor, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}