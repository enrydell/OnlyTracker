/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.jms;

import java.util.Queue;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

/**
 *
 * @author henrique
 */
@Stateless
public class JMSProducer implements JMSProducerLocal {

    @Resource(mappedName = "jms/lp3")
    private javax.jms.Queue lp3;

    @Inject
    @JMSConnectionFactory("jms/lp3Factory")
    private JMSContext context;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    private void sendJMSMessageToLp3(String messageData) {
        context.createProducer().send(lp3, messageData);
    }
        
    @Override
    public void sendMessage(String message) {
        this.sendJMSMessageToLp3(message);
    }
    
}
