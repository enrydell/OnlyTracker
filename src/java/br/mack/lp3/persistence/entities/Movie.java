/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author 31538088
 */
@Entity
public class Movie implements Serializable {

    private String title;
    @Transient
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot; 
    @Transient
    private String language; 
    @Transient
    private String country; 
    @Transient
    private String awards;
    @Transient
    private String poster; 
    @Transient
    private int metascore;
    @Transient
    private double imdbRating;
    @Transient
    private double imdbVotes;
    private String type;
    private String imdbID; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_id;

    public Movie(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, int metascore, double imdbRating, double imdbVotes, String type, String imdbID, long movie_id) {
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
        this.type = type;
        this.imdbID = imdbID;
        this.movie_id = movie_id;
    }

    public Movie() {
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

    public long getMovie_id() {
        return movie_id;
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

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country + ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", type=" + type + ", imdbID=" + imdbID + ", movie_id=" + movie_id + '}';
    }

}
