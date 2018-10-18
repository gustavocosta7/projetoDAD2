/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author Suporte
 */
@Entity
public class Categoria {
    @Id
    private long id;
    private String descricao;
    private double percentual;

    public Categoria() {
    }

    public Categoria(String descricao, double percentual) {
        this.descricao = descricao;
        this.percentual = percentual;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }
    
    
}
