/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.persistence.UserLP3DAO;
import br.mack.lp3.persistence.entities.UserLP3;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 31566278
 */
public class LoginController extends AbstractController{
    UserLP3DAO userLP3DAO = lookupUserLP3DAOBean();
    
    @Override
    public void execute() {
        String email = this.getRequest().getParameter("email");
        String password = this.getRequest().getParameter("password");
        
        UserLP3 userExistente = userLP3DAO.readByEmail(email);
        if(userExistente == null){
            this.getRequest().getSession().setAttribute("error", "Usuário não encontrado.");
            this.setReturnPage("error.jsp");
        }
        else{
            if(password.equals(userExistente.getPassword())){
                this.getRequest().getSession().setAttribute("user", userExistente);
                this.setReturnPage("index.jsp");
            }
            else{
                this.getRequest().getSession().setAttribute("error", "Senha incorreta");
                this.setReturnPage("error.jsp");
            }
        }
    }

    private UserLP3DAO lookupUserLP3DAOBean() {
        try {
            Context c = new InitialContext();
            return (UserLP3DAO) c.lookup("java:global/OnlyTrackerApp/UserLP3DAO!br.mack.lp3.persistence.UserLP3DAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
