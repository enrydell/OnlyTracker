/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.persistence.ColecaoDAO;
import br.mack.lp3.persistence.MovieDAO;
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
 * @author 31538088
 */
public class CollectionAddController extends AbstractController {

    UserLP3DAO userLP3DAO = lookupUserLP3DAOBean();

    MovieDAO movieDAO = lookupMovieDAOBean();

    ColecaoDAO colecaoDAO = lookupColecaoDAOBean();

    
    @Override
    public void execute() {
        
//        UserLP3 user = (UserLP3) this.getRequest().getSession().getAttribute("user");
//        Movie movie = (Movie) this.getRequest().getSession().getAttribute("movie");
////        user.getMovies().add(movie);
//        UserLP3 userAlterado = colecaoDAO.create(movie, user);
//        this.getRequest().getSession().setAttribute("user", userAlterado);
        this.setReturnPage(this.getRequest().getContextPath() + "/user/feed.jsp");
    }

    private ColecaoDAO lookupColecaoDAOBean() {
        try {
            Context c = new InitialContext();
            return (ColecaoDAO) c.lookup("java:global/OnlyTrackerApp/ColecaoDAO!br.mack.lp3.persistence.ColecaoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MovieDAO lookupMovieDAOBean() {
        try {
            Context c = new InitialContext();
            return (MovieDAO) c.lookup("java:global/OnlyTrackerApp/MovieDAO!br.mack.lp3.persistence.MovieDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
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
