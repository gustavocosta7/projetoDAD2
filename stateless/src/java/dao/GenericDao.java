/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Suporte
 */

import java.util.List;
import javax.persistence.EntityManager;
public class GenericDao <T> {
    
    private EntityManager entityManager;
    
    public GenericDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void save(T obj){
        try{
            entityManager.persist(obj);
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        System.out.println("salvando.." + obj.getClass().getName());
    }
    
    public void update(T obj){
        try{
            entityManager.merge(obj);
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
        System.out.println("alterando.." + obj.getClass().getName());

    }
    
    public void remove(Class<T> obj, Long id){
        T t = findById(obj, id);
        try{
            entityManager.remove(t);
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        System.out.println("excluindo.." + obj.getName());

    }
    
    public T findById(Class<T> obj, Long id){
        System.out.println("bucando por id.." + obj.getName());
        return entityManager.find(obj, id);
    }
    
    public List<T> findAll(Class<T> obj){
        return entityManager.createQuery("Select t from " + obj.getSimpleName() + " t").getResultList();
    }
    
    
}