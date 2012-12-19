/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author marcelo
 */
public abstract class Dao<T> implements IDao<T>, Serializable {

    private final Class obj;
    //private EntityManager em = null;
    //private EntityManagerFactory emf = null;   
    @Inject
    private EntityManager em;

    public Dao(Class obj) {
        this.obj = obj;
        //emf = Persistence.createEntityManagerFactory("Teste2PU");
        //em = emf.createEntityManager();
    }

    @Override
    public void salvar(T obj) {
        //System.out.println(obj.getClass());
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}
