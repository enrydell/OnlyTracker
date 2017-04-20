/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.parsers;

import br.mack.lp3.persistence.entities.Movie;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author 41514181
 */
public class XMLParser {
    
    private Document doc;
    private DocumentBuilder db;
    
    
    public XMLParser() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openFile(File file) {
        try {
            doc = db.parse(file);
        } catch (SAXException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openURL(String uri) {
        try {
            URL url = new URL(uri);
            
            //Conexão HTTP
            //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.10", 3128));
            //HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            int code = conn.getResponseCode();
            
            switch(code) {
                case 407:
                    System.out.println("Falha na autenticação do Proxy.");
                    break;
                case 200:
                    
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    
                    br.close();
                    
                    conn.disconnect();
                    
                    String content = sb.toString();
                    
                    doc = db.parse(new InputSource(new StringReader(content)));
                    
                    break;
                default:
                    System.out.println("Erro não especificado.");
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Movie parseMovie(Element element) {
        Movie mv = new Movie();
        
        if(element.getElementsByTagName("movie").item(0) != null) {
            Element movie = (Element) element.getElementsByTagName("movie").item(0);
            System.out.println(movie);
            String title = movie.getAttribute("title");
            String year = movie.getAttribute("year");
            String released = movie.getAttribute("released");
            String poster = movie.getAttribute("poster");
            
            mv.setTitle(title);
            mv.setYear(year);
            mv.setReleased(released);
            mv.setPoster(poster);
        }
        
        return mv;
    }

    public Document getDoc() {
        return doc;
    }
    
    
}
