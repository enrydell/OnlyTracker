/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.parsers.XMLParser;
import br.mack.lp3.persistence.entities.Movie;
import org.w3c.dom.Element;

/**
 *
 * @author 41514181
 */
public class BuscaController extends AbstractController {

    @Override
    public void execute() {
        XMLParser xmlpr = new XMLParser();
        String mode = "xml";
        xmlpr.openURL("http://www.omdbapi.com/?t="+this.getRequest().getParameter("q").replace(" ", "%20")+"&r="+mode);
        
        Element raiz = xmlpr.getDoc().getDocumentElement();
        Movie mv = xmlpr.parseMovie(raiz);
        
        this.getRequest().getSession().setAttribute("movie", mv);
        this.setReturnPage("index.jsp");
    }
    
}
