///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.mack.lp3.persistence.entities;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
///**
// *
// * @author enrydell
// */
//@Entity
//public class Colecao implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id_colecao;
//    @OneToMany(targetEntity = UserLP3.class)
//    private List<UserLP3> userlp3;
//    @OneToMany(targetEntity = Movie.class)
//    private List<Movie> movie_id;
//
//    public Colecao() {
//    }
//
//    public Colecao(long id_colecao, List<UserLP3> userlp3, List<Movie> movie_id) {
//        this.id_colecao = id_colecao;
//        this.userlp3 = userlp3;
//        this.movie_id = movie_id;
//    }
//
//    public long getId_colecao() {
//        return id_colecao;
//    }
//
//    public List<UserLP3> getUserlp3() {
//        return userlp3;
//    }
//
//    public void setUserlp3(List<UserLP3> userlp3) {
//        this.userlp3 = userlp3;
//    }
//
//    public List<Movie> getMovie_id() {
//        return movie_id;
//    }
//
//    public void setMovie_id(List<Movie> movie_id) {
//        this.movie_id = movie_id;
//    }
//    
//    
//}
