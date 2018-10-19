/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import modelo.Categoria;
import modelo.IProdutoService;
import view.ProdutoCadastrarTela;

/**
 *
 * @author gustav0
 */
public class ProdutoCadastrarController {
    
    private ProdutoCadastrarTela tela;
    
    private IProdutoService ps;
    private List<Categoria> categorias = new ArrayList<>();

    public ProdutoCadastrarController(ProdutoCadastrarTela tela) {
        this.tela = tela;
        conectaService();
        carregaCombo();
        this.tela.addBtnSalvar(new CadastrarProduto());
    }
    /**
     * Inicializa service
     */
    public void conectaService(){
        
        
        try {
             InitialContext context = new InitialContext();
             ps = (IProdutoService) context.lookup("ejb:/stateless/ProdutoService!modelo.IProdutoService");
        } catch (NamingException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
       
    }
    /**
     * Carrega combobox categorias
     */
    public void carregaCombo(){
        categorias = ps.listarCategoria();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Categoria categoria : categorias) {
            model.addElement(categoria.getDescricao());
        }
        tela.getCbCategoria().setModel(model);

    }
/**
 * Cadastra objeto no banco
 */    
    private class CadastrarProduto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

        
    }
    
    
    
    
}
