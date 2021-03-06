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
 * @author Conversion
 */
public class AtualizarController extends AbstractController {

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
        
        UserLP3 user = (UserLP3) this.getRequest().getSession().getAttribute("user");
        if((!email.equals(user.getEmail()) && userLP3DAO.readByEmail(email) == null) || email.equals(user.getEmail())) {
            if(password.equals(verify_password)) {
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setBirthday(birthday);

                userLP3DAO.update(user);
                this.getRequest().getSession().setAttribute("user", user);
                this.setReturnPage(this.getRequest().getContextPath() + "/user/feed.jsp");
            } else {
                this.getRequest().getSession().setAttribute("error", "Senhas não são iguais");
                this.setReturnPage(this.getRequest().getContextPath() + "/user/profile.jsp");
            }
        } else {
            this.getRequest().getSession().setAttribute("error", "Email já cadastrado");
            this.setReturnPage(this.getRequest().getContextPath() + "/user/profile.jsp");
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
