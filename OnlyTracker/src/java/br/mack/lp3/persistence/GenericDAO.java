/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence;

import java.util.List;

/**
 *
 * @author 41514181
 */
public interface GenericDAO<E> {
    public void create(E e);
    public E readById(long id);
    public List<E> readAll();
    public void update(E e);
    public void remove(E e);
}
