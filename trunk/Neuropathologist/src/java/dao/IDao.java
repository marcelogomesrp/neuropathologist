/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author marcelo
 */
public interface IDao<T> {
    public void salvar(T obj);
    
}
