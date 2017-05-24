/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.jms;

import javax.ejb.Local;

/**
 *
 * @author henrique
 */
@Local
public interface JMSProducerLocal {
    void sendMessage(String message);
}
