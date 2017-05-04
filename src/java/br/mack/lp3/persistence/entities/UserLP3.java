/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 41514181
 */
@Entity
public class UserLP3 implements Serializable {
    private String name, email, password;
    
    @ElementCollection
    @CollectionTable(name="Series_e_filmes_dos_usuarios", joinColumns=@JoinColumn(name="id_userlp3"))
    @Column(name="movie_id")
    @OneToMany
    private Collection<Movie> movies;
    
    @Temporal (TemporalType.DATE)
    private Date birthday;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_userlp3;
    
    public UserLP3() {
    }

    public UserLP3(String name, String email, String password, Date birthday, long id_userlp3) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.id_userlp3 = id_userlp3;
        this.movies = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId_userlp3() {
        return id_userlp3;
    }

    public void setId_userlp3(long id_userlp3) {
        this.id_userlp3 = id_userlp3;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String birthdayToString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.birthday);
    }

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
}
