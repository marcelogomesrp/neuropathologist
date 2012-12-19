/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuarioDao;
import java.io.Serializable;
import javax.inject.Inject;
import model.Usuario;

/**
 *
 * @author marcelo
 */
public class UsuarioService implements Serializable{
    
    @Inject
    private UsuarioDao usuarioDao;
    
    public void salvar(Usuario usuario){
        usuarioDao.salvar(usuario);
    }
    
}
