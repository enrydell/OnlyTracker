/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.persistence.UserLP3DAO;
import br.mack.lp3.persistence.entities.Movie;
import br.mack.lp3.persistence.entities.UserLP3;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author enrydell
 */
public class CollectionRemoveController extends AbstractController {
    
    UserLP3DAO userLP3DAO = lookupUserLP3DAOBean();
    
    @Override
    public void execute() {
        
        UserLP3 user = (UserLP3) this.getRequest().getSession().getAttribute("user");
        Movie movie = (Movie) this.getRequest().getSession().getAttribute("movie");
        user.getMovies().remove(movie);
        userLP3DAO.update(user);
        this.getRequest().getSession().setAttribute("user", user);
        this.setReturnPage(this.getRequest().getContextPath() + "/user/feed.jsp");
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
