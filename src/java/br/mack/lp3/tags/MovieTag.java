package br.mack.lp3.tags;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author enrydell
 */
public class MovieTag extends SimpleTagSupport {

    private StringWriter sw = new StringWriter();

    public void setSw(StringWriter sw) {
        this.sw = sw;
    }
    
    private String title, poster, released;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setReleased(String released) {
        this.released = released;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String card = "<div class='movie'>"
                + "<figure><img src='https://image.tmdb.org/t/p/w640"+poster+"'/></figure>"
                + "<h2>"+title+"</h2>"
                + "<span>Lançamento: "+released+"</span>"
                + "</div>";
        
        out.print(card);
    }
    
}
