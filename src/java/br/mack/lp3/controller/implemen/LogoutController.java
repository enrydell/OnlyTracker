/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.implemen;

import br.mack.lp3.controller.AbstractController;

/**
 *
 * @author Conversion
 */
public class LogoutController extends AbstractController {

    @Override
    public void execute() {
        this.getRequest().getSession().invalidate();
        this.setReturnPage(this.getRequest().getContextPath() + "/index.jsp");
    }
    
}
