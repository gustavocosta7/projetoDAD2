/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class ProdutoTableModel extends AbstractTableModel {
    List<Produto> produtos = null;

    public String[] colunas = {"Codigo", "Nome", "Valor","Categoria"};
    
    public ProdutoTableModel(List<Produto> produtos){
        this.produtos = produtos;    
    }

    public Object[] getListenerList() {
        return listenerList.getListenerList();
    }

    
    @Override
    public String getColumnName(int num){
        return this.colunas[num];
    }
    
    @Override
    public int getRowCount() {   
        if (produtos == null)
            return 0;
        
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    public Produto getPessoa(int linha){
        return this.produtos.get(linha);
    }
            
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        
        
        switch(columnIndex){
            case 0: return produto.getCodigo();            
            case 1: return produto.getNome();           
            case 2: return "R$ "+produto.getValor();
            case 3: return produto.getCategoria().getDescricao();

        }
        return null;
    }
        
    
}
