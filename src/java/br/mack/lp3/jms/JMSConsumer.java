/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.jms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author henrique
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/lp3"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class JMSConsumer implements MessageListener {
    
    public JMSConsumer() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            File file  = new File("/home/henrique/Desktop/Dev/Java/TesteJMS/log.txt");
            String texto = "";
            
            if(file.canRead()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linha = "";
                while((linha = br.readLine()) != null) {
                    texto = texto + linha + "\n";
                }
                saveFile(texto,tm,file);
                br.close();
                fr.close();
            } else {
                saveFile(texto,tm,file);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void saveFile(String texto, TextMessage tm, File file) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            texto = texto + sdf.format(new Date()) + " - " + tm.getText();
            fos.write(texto.getBytes());
            fos.close();
        } catch (IOException | JMSException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
}
