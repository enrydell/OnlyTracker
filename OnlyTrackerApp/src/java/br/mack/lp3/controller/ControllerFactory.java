/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41514181
 */
public class ControllerFactory {
    public static Controller getInstanceByName(String name) {
        Controller instance = null;
        
        String className = "br.mack.lp3.controller.implemen." + name + "Controller";
        try {
            instance = (Controller) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return instance;
    }
}
