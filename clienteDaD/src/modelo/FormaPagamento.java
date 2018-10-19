
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Suporte
 */
public class FormaPagamento {
    private long id;
    private String descricao;
    private long parcela;

    
    public FormaPagamento() {
    }

    public FormaPagamento(long id, String descricao, long parcela) {
        this.id = id;
        this.descricao = descricao;
        this.parcela = parcela;
    }

    public FormaPagamento(String descricao, long parcela) {
        this.descricao = descricao;
        this.parcela = parcela;
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

    public long getParcela() {
        return parcela;
    }

    public void setParcela(long parcela) {
        this.parcela = parcela;
    }
    
    
}
