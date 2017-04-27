/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence;

import br.mack.lp3.persistence.entities.UserLP3;
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
 * @author 41514181
 */
@LocalBean
@Stateful
public class UserLP3DAO implements GenericDAO<UserLP3> {
    
    @PersistenceContext(unitName = "OnlyTrackerPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(UserLP3 e) {
        em.persist(e);
    }

    @Override
    public UserLP3 readById(long id) {
        return em.find(UserLP3.class, id);
    }

    @Override
    public List<UserLP3> readAll() {
        Query query = em.createQuery("SELECT u FROM UserLP3 u");
        return (List<UserLP3>) query.getResultList();
    }
    
    public UserLP3 readByEmail(String email) {
        Query query = em.createQuery("SELECT u FROM UserLP3 u WHERE u.email=:n");
        try {
            return (UserLP3) query.setParameter("n", email).getSingleResult();
        } catch(NoResultException ex) {
            return null;
        }
    }

    @Override
    public void update(UserLP3 e) {
        em.merge(e);
    }

    @Override
    public void remove(UserLP3 e) {
        em.remove(em.merge(e));
    }
    
}
