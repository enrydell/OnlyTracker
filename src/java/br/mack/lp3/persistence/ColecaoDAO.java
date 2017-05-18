/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence;

import br.mack.lp3.persistence.entities.Movie;
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
public class ColecaoDAO implements GenericDAO<Collection<Movie>> {
    
    @PersistenceContext(unitName = "OnlyTrackerPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(Collection<Movie> e) {
        for(Movie movie : e){
            em.persist(movie.getMovie_id());            
        }
    }

    @Override
    public Collection<Movie> readById(long id) {
        return null;
        //return em.find(Collection<Movie>.class, id);
    }

    @Override
    public List<Collection<Movie>> readAll() {
        Query query = em.createQuery("SELECT u FROM Collection<Movie> u");
        return (List<Collection<Movie>>) query.getResultList();
    }

    @Override
    public void update(Collection<Movie> e) {
        for(Movie movie : e){
            em.merge(movie.getMovie_id());            
        }
    }

    @Override
    public void remove(Collection<Movie> e) {
         for(Movie movie : e){
            em.remove(em.merge((movie.getMovie_id())));            
        }
    }
    
    public Collection<Movie> getMoviesForUser(long id_userlp3){
        //MovieDAO moviedao = new MovieDAO();
        Query query = em.createQuery("SELECT movie_id from Collection<Movie> c where c.id_userlp3=:n");
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
