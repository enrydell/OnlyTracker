/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence.entities;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author enrydell
 */
@Entity
public class Colecao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_colecao;
    @OneToMany(targetEntity = UserLP3.class)
    private long id_userlp3;
    @OneToMany(targetEntity = Movie.class)
    private long movie_id;

    public Colecao() {
    }

    public Colecao(long id_colecao, long id_userlp3, long movie_id) {
        this.id_colecao = id_colecao;
        this.id_userlp3 = id_userlp3;
        this.movie_id = movie_id;
    }

    public long getId_colecao() {
        return id_colecao;
    }

    public long getId_userlp3() {
        return id_userlp3;
    }

    public void setId_userlp3(long id_userlp3) {
        this.id_userlp3 = id_userlp3;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }
    
    
}
