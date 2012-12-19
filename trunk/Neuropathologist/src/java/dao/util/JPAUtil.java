/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marcelo
 */
public class JPAUtil {
    
    @Produces @ApplicationScoped
    public EntityManagerFactory criarFactory(){
        return Persistence.createEntityManagerFactory("NeuropathologistPU");
    }
    
    @Produces @RequestScoped
    public EntityManager criarEM(EntityManagerFactory factory){
        return factory.createEntityManager();
    }
    
    public void fechaEM(EntityManager em){
        em.close();
    }
    
}
