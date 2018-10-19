/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import ejb.ConectaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import modelo.IProdutoService;
import modelo.Produto;
import modelo.ProdutoTableModel;
import view.ProdutoAlterarTela;
import view.ProdutoCadastrarTela;
import view.ProdutoPesquisarTela;

/**
 *
 * @author gustav0
 */
public class ProdutoPesquisarController {
    private ProdutoPesquisarTela tela;
    
    private List<Produto> produtos;
    private IProdutoService ps;

 

    public ProdutoPesquisarController(ProdutoPesquisarTela tela) {
        this.tela = tela;
        ps = ConectaService.conectaIProdutoService();
        produtos = ps.listar();
        carregaTabela();
        
        this.tela.addBtnPesquisar(new Pesquisar());
        this.tela.addBtnCadastrar(new Cadastrar());
        this.tela.addTbProdutos(new SelecionaLinha());
        
    }
    
    /**
     * Carrega tabela
     */
    public void carregaTabela(){
        ProdutoTableModel model = new ProdutoTableModel(produtos);
        this.tela.setTbProdutos(model);
    }
/**
 * Seleciona linha para alterar
 */
    private class SelecionaLinha implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
                Produto p = produtos.get(tela.getTbProdutos().getSelectedRow());
                ProdutoAlterarTela telaP = new ProdutoAlterarTela();
                ProdutoAlterarController pcc = new ProdutoAlterarController(telaP,p);
                telaP.setVisible(true);
                telaP.setLocationRelativeTo(null);

                tela.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
/**
 * Pesquisa produto
 */
    private class Pesquisar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String pesquisa = tela.getTfPesquisa();
            produtos.clear();
            
            produtos = ps.pesquisaProduto(pesquisa, "nome");
            carregaTabela();
        
        }

    }   
    
    private class Cadastrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                    ProdutoCadastrarTela telaCad = new ProdutoCadastrarTela();
                    ProdutoCadastrarController pcc = new ProdutoCadastrarController(telaCad);
                    telaCad.setVisible(true);
                    telaCad.setLocationRelativeTo(null);
        
                    tela.dispose();
         }

    } 
    
}
