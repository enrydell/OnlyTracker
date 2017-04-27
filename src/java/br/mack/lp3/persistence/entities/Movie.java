/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence.entities;

import java.io.Serializable;

/**
 *
 * @author 31538088
 */
public class Movie implements Serializable {

    private String title;
    private String year;
    private String rated;
    private String released; 
    private String runtime; 
    private String genre; 
    private String director; 
    private String writer; 
    private String actors; 
    private String plot; 
    private String language; 
    private String country; 
    private String awards; 
    private String poster; 
    private int metascore;
    private double imdbRating;
    private double imdbVotes;
    private String imdbID; 
    private String type; 

    public Movie(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, int metascore, double imdbRating, double imdbVotes, String imdbID, String type) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.type = type;
    }

    public Movie() {
        this.title = "X";
        this.year = "0";
        this.rated = "X";
        this.released = "X";
        this.runtime = "X";
        this.genre = "X";
        this.director = "X";
        this.writer = "X";
        this.actors = "X";
        this.plot = "X";
        this.language = "X";
        this.country = "X";
        this.awards = "X";
        this.poster = "X";
        this.metascore = 0;
        this.imdbRating = 0;
        this.imdbVotes = 0;
        this.imdbID = "X";
        this.type = "X";
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public int getMetascore() {
        return metascore;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public double getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setImdbVotes(double imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country + ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + ", type=" + type + '}';
    }
}
