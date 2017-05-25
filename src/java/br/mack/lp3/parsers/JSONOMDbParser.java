/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.parsers;

import br.mack.lp3.persistence.entities.Movie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author henrique
 */
public class JSONOMDbParser {
    
    private String content;
    
    public JSONOMDbParser() {
        
    }
    
    public void read(String query, String type) {
        try {
//            URL url = new URL("http://www.omdbapi.com/?t="+URLEncoder.encode(query, "UTF-8")+"&apikey=f2dfb394");
            URL url = new URL("http://api.themoviedb.org/3/search/"+type+"?query="+URLEncoder.encode(query, "UTF-8")+"&api_key=b5f1f7351a29cf5239c2deb9d478f1e5");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            int code = connection.getResponseCode();
            
            switch(code) {
                case 200:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    
                    br.close();
                    connection.disconnect();
                    
                    content = sb.toString();
                    break;
                default:
                    System.out.println("Erro no JSON Parser.");
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JSONOMDbParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONOMDbParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Movie parseJSON() {
        Movie movie = new Movie();
        
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject rootFirst = reader.readObject();
        JsonObject root = (JsonObject) rootFirst.getJsonArray("results").get(0);
        String overview = root.getJsonString("overview").getString();
        
        /*root.getJsonString("Response").getString().equals("True")*/
        if(root.getJsonNumber("status_code") == null && !overview.equals("")) {
//            String id = root.getJsonString("imdbID").getString();
            String id = root.getJsonNumber("id").toString();
//            String name = root.getJsonString("Title").getString();
            String name = root.getJsonString("name") == null ? root.getJsonString("title").getString() : root.getJsonString("name").getString();
//            String rated = root.getJsonString("Rated").getString();
//            String released = root.getJsonString("Released").getString().equals("N/A") ? "Não há informações" : root.getJsonString("Released").getString();
            String released = root.getJsonString("first_air_date") == null ? root.getJsonString("release_date").getString() : root.getJsonString("first_air_date").getString();
//            String genre = root.getJsonString("Genre").getString().equals("N/A") ? "Não há informações" : root.getJsonString("Genre").getString();
//            String poster = root.getJsonString("Poster").getString().equals("N/A") ? "Não há informações" : root.getJsonString("Poster").getString();
            String poster = root.getJsonString("poster_path").getString();
//            String actors = root.getJsonString("Actors").getString();
//            String director = root.getJsonString("Director").getString();
//            String plot = root.getJsonString("Plot").getString();
            String plot = root.getJsonString("overview").getString().length() > 255 ? root.getJsonString("overview").getString().substring(0, 255) : root.getJsonString("overview").getString();
//            String runtime = root.getJsonString("Runtime").getString();
//            String type = root.getJsonString("Type").getString();
//            String writer = root.getJsonString("Writer").getString();
            
            movie.setActors(/*actors*/null);
            movie.setDirector(/*director*/null);
            movie.setPlot(plot);
            movie.setRuntime(/*runtime*/null);
            movie.setType(/*type*/null);
            movie.setWriter(/*writer*/null);
            movie.setImdbID(id);
            movie.setTitle(name);
//            switch(rated) {
//                case "G":
//                    rated = "Livre";
//                    break;
//                case "TV-PG":
//                    rated = "Não recomendado para crianças pequenas";
//                    break;
//                case "PG-13":
//                    rated = "Não recomendado para crianças menores de 13 anos";
//                    break;
//                case "R":
//                    rated = "Proibido para menores de 17 anos desacompanhados";
//                    break;
//                case "NC-17":
//                    rated = "Proibido para menores de 18 anos";
//                    break;
//                case "TV-MA":
//                    rated = "Menores de 15 anos, apenas acompanhados";
//                    break;
//                case "N/A":
//                    rated = "Não há informações";
//                default:
//                    System.out.println("Classificação não reconhecida");
//            }
            movie.setRated(/*rated*/null);
            movie.setReleased(released);
            movie.setGenre(/*genre*/null);
            movie.setPoster(poster);
            
        } else {
            movie.setTitle("Não encontrado!");
        }
        
        return movie;
    }
    
}
