/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence;

import br.mack.lp3.persistence.entities.Movie;
import br.mack.lp3.persistence.entities.UserLP3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Maurício Eidi
 */
@LocalBean
@Stateful
public class ColecaoDAO implements GenericDAO<Movie> {
    
    @PersistenceContext(unitName = "OnlyTrackerPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(Movie e) {
        em.persist(e);
    }
    
    public UserLP3 create(Movie movie, UserLP3 user) {
//        Query query = em.createQuery("UPDATE MACK.COLECAO SET id_userlp3=:i,movie_id=:m");
//        query.setParameter("i", id_userlp3);
//        query.setParameter("m", movie_id);
//        query.executeUpdate();
          user.getMovies().add(movie);
          return user;
    }

    @Override
    public Movie readById(long id) {
        return null;
        //return em.find(Collection<Movie>.class, id);
    }

    @Override
    public List<Movie> readAll() {
        Query query = em.createQuery("SELECT u FROM Colecao u");
        return (List<Movie>) query.getResultList();
    }

    @Override
    public void update(Movie e) {
//        for(Movie movie : e){
//            em.merge(movie.getMovie_id());            
//        }
    }

    @Override
    public void remove(Movie e) {
//         for(Movie movie : e){
//            em.remove(em.merge((movie.getMovie_id())));            
//        }
    }
    
    public Collection<Movie> getMoviesForUser(long id_userlp3){
        //MovieDAO moviedao = new MovieDAO();
        Query query = em.createQuery("SELECT movie_id FROM Colecao c WHERE c.id_userlp3=:n");
        try{
            query.setParameter("n", id_userlp3);
            Collection<Movie> lista = new ArrayList<>();
            lista = query.getResultList();
            return lista;
        }catch (NoResultException ex){
            return null;
        }
    }
}
