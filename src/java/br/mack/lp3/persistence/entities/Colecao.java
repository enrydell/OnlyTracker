/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence.entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author enrydell
 */
public class Colecao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_colecao;
    private long id_userlp3;
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
