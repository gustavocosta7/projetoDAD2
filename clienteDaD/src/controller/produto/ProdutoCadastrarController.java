/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import ejb.ConectaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Categoria;
import modelo.IProdutoService;
import modelo.Produto;
import view.ProdutoCadastrarTela;
import view.ProdutoPesquisarTela;

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
        ps = ConectaService.conectaIProdutoService();
        carregaCombo();
        this.tela.addBtnSalvar(new CadastrarProduto());
        this.tela.addBtnVoltar(new Voltar());
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

    private class Voltar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                ProdutoPesquisarTela telaP = new ProdutoPesquisarTela();
                ProdutoPesquisarController pcc = new ProdutoPesquisarController(telaP);
                telaP.setVisible(true);
                telaP.setLocationRelativeTo(null);

                tela.dispose();
        
        }
    }
/**
 * Cadastra objeto no banco
 */    
    private class CadastrarProduto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double valor = Double.parseDouble(tela.getTfValor());
            String nome = tela.getTfNome();
            Categoria categoria = categorias.get(tela.getCbCategoria().getSelectedIndex());
            
            Produto produto = new Produto(nome, valor, categoria);
            ps.inserir(produto);
            
            tela.showMensagemSucesso("Adicionado com sucesso!");
            
            tela.setTfNome("");
            tela.setTfValor("");
            
                       
        }
        
        
    }
}
