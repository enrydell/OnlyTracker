/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence;

import br.mack.lp3.persistence.entities.Movie;
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
public class MovieDAO implements GenericDAO<Movie>{
    
    @PersistenceContext(unitName = "OnlyTrackerPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(Movie e) {
        em.persist(e);
    }

    @Override
    public Movie readById(long id) {
        return em.find(Movie.class, id);
    }

    @Override
    public List<Movie> readAll() {
        Query query = em.createQuery("SELECT u FROM Movie u");
        return (List<Movie>) query.getResultList();
    }
    
    public Movie readByEmail(String email) {
        Query query = em.createQuery("SELECT u FROM Movie u WHERE u.email=:n");
        try {
            return (Movie) query.setParameter("n", email).getSingleResult();
        } catch(NoResultException ex) {
            return null;
        }
    }

    @Override
    public void update(Movie e) {
        em.merge(e);
    }

    @Override
    public void remove(Movie e) {
        em.remove(em.merge(e));
    }
}
