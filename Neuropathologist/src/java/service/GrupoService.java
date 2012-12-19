/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GrupoDao;
import java.io.Serializable;
import javax.inject.Inject;
import model.Grupo;

/**
 *
 * @author marcelo
 */
public class GrupoService implements Serializable {
    @Inject
    private GrupoDao grupoDao;
    
        public void salvar(Grupo grupo){
        grupoDao.salvar(grupo);
    }
    
}
