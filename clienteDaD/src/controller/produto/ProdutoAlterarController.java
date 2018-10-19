/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import ejb.ConectaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Categoria;
import modelo.IProdutoService;
import modelo.Produto;
import view.ProdutoAlterarTela;
import view.ProdutoPesquisarTela;

/**
 *
 * @author gustav0
 */
public class ProdutoAlterarController {
    
    private ProdutoAlterarTela tela;
    private IProdutoService ps;
    
    private List<Categoria> categorias;
    private Produto produto;

    public ProdutoAlterarController(ProdutoAlterarTela tela, Produto produto) {
        
        this.tela = tela;
        this.produto = produto;
        
        ps = ConectaService.conectaIProdutoService();
        carregaCombo();
        carregaComponentes();
        
        this.tela.addBtnSalvar(new Alterar());
        this.tela.addBtnExcluir(new Excluir());
        this.tela.addBtnVoltar(new Voltar());
    }
    /**
     * Carrega componentes de acordo com o objeto recebido
     */
    public void carregaComponentes(){
        this.tela.setTfNome(produto.getNome());
        this.tela.setTfValor(produto.getValor()+"");
        int index =  0;
        
        for (int i = 0; i < categorias.size(); i++) {
            if(categorias.get(i).getDescricao() == produto.getCategoria().getDescricao()){
                index = i;
                break;
            }
        }
        
        this.tela.getCbCategoria().setSelectedIndex(index);
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
 * Altera produto
 */
    private class Alterar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = tela.getTfNome();
            double valor = Double.parseDouble(tela.getTfValor());
            Categoria categoria = categorias.get(tela.getCbCategoria().getSelectedIndex());
            Produto p = new Produto(nome, valor, categoria);
            p.setCodigo(produto.getCodigo());
            
            ps.alterar(p);
            
            voltar();
        }

    }
/**
 * Volta 
 */
    private class Excluir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = tela.getTfNome();
            double valor = Double.parseDouble(tela.getTfValor());
            Categoria categoria = categorias.get(tela.getCbCategoria().getSelectedIndex());
            Produto p = new Produto(nome, valor, categoria);
            p.setCodigo(produto.getCodigo());
            
            ps.remover(p);
            
            voltar();
        }

    }
    /**
 * Volta tela
 */
    private class Voltar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                voltar();
        }

    }
    
    public void voltar(){
                ProdutoPesquisarTela telaP = new ProdutoPesquisarTela();
                ProdutoPesquisarController pcc = new ProdutoPesquisarController(telaP);
                telaP.setVisible(true);
                telaP.setLocationRelativeTo(null);

                tela.dispose();
    }
}
