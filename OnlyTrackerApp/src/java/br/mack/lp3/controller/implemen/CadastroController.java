/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.persistence.UserLP3DAO;
import br.mack.lp3.persistence.entities.UserLP3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41514181
 */
public class CadastroController extends AbstractController {

    UserLP3DAO userLP3DAO = lookupUserLP3DAOBean();
    
    @Override
    public void execute() {
        String name = this.getRequest().getParameter("nome");
        String email = this.getRequest().getParameter("email");
        String password = this.getRequest().getParameter("password");
        String verify_password = this.getRequest().getParameter("password_to_verify");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = formatter.parse(this.getRequest().getParameter("birthday"));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(password.equals(verify_password) && birthday != null) {
            UserLP3 user = new UserLP3();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setBirthday(birthday);

            UserLP3 userEncontrado = userLP3DAO.readByEmail(email);
            if(userEncontrado == null) {
                userLP3DAO.create(user);
                UserLP3 userRead = userLP3DAO.readByEmail(email);
                this.getRequest().getSession().setAttribute("user", userRead);
                this.setReturnPage("index.jsp");
            } else {
                this.setReturnPage("error.jsp");
            }
        } else {
            this.setReturnPage("error.jsp");
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
