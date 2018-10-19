/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.IProdutoService;

/**
 *
 * @author gustav0
 */
public class ConectaService {
    
        public static IProdutoService conectaIProdutoService(){
        
        IProdutoService ps = null;
        try {
             InitialContext context = new InitialContext();
             return ps = (IProdutoService) context.lookup("ejb:/stateless/ProdutoService!modelo.IProdutoService");
        } catch (NamingException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
       return ps;
    }
}
