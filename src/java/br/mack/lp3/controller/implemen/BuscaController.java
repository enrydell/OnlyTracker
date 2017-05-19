/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.parsers.JSONOMDbParser;
import br.mack.lp3.persistence.MovieDAO;
import br.mack.lp3.persistence.entities.Movie;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41514181
 */
public class BuscaController extends AbstractController {

    MovieDAO movieDAO = lookupMovieDAOBean();
    
    @Override
    public void execute() {
        JSONOMDbParser jsonpr = new JSONOMDbParser();
        jsonpr.read(this.getRequest().getParameter("q"));
        Movie movie = jsonpr.parseJSON();
        if(!movie.getTitle().equals("Não encontrado!")) {
            Movie movieRead = movieDAO.readByTitle(movie.getTitle());
            if(movieRead == null) {
                movieDAO.create(movie);
                movieRead = movieDAO.readByTitle(movie.getTitle());
                this.getRequest().getSession().setAttribute("movie", movieRead);
                this.setReturnPage(this.getRequest().getContextPath() + "/user/feed.jsp");
            } else {
                movie.setMovie_id(movieRead.getMovie_id());
                movieDAO.update(movie);
                this.getRequest().getSession().setAttribute("movie", movie);
                this.setReturnPage(this.getRequest().getContextPath() + "/user/feed.jsp");
            }
        } else {
            this.getRequest().getSession().setAttribute("movie", movie);
            this.setReturnPage(this.getRequest().getContextPath() + "/user/feed.jsp");
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

}
