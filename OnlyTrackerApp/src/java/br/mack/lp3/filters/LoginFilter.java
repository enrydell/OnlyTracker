/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 41514181
 */

@WebServlet (urlPatterns = "/*")
public class LoginFilter implements Filter {
    HttpServletRequest request;
    HttpServletResponse response;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    public void init(FilterConfig filterConfig, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        this.request = request;
        this.response = response;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request.getAttribute("user") == null) {
            
        } else {
            
        }
    }

    @Override
    public void destroy() {
    }
    
}
