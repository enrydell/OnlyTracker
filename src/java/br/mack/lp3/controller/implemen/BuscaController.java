/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.parsers.JSONOMDbParser;
import br.mack.lp3.persistence.entities.Movie;

/**
 *
 * @author 41514181
 */
public class BuscaController extends AbstractController {

    @Override
    public void execute() {
        /*
        XMLParser xmlpr = new XMLParser();
        String mode = "xml";
        xmlpr.openURL("http://www.omdbapi.com/?t="+this.getRequest().getParameter("q").replace(" ", "%20")+"&r="+mode);
        
        Element raiz = xmlpr.getDoc().getDocumentElement();
        Movie mv = xmlpr.parseMovie(raiz);
        */
        
        JSONOMDbParser jsonpr = new JSONOMDbParser();
        jsonpr.read(this.getRequest().getParameter("q"));
        Movie movie = jsonpr.parseJSON();
        
        if(!movie.getTitle().equals("Não encontrado!")) {
            this.getRequest().getSession().setAttribute("movie", movie);
        } else {
            this.getRequest().getSession().setAttribute("movie", null);
            this.getRequest().getSession().setAttribute("error", movie);
        }
        
        this.setReturnPage(this.getRequest().getContextPath() + "/user/feed.jsp");
    }
    
}
