/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import model.Usuario;
import service.UsuarioService;

/**
 *
 * @author marcelo
 */
@Named(value = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable {
    @Inject
    private UsuarioService usuarioService;
    private Usuario usuario;
       
    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
    }
    @PostConstruct 
    public void init(){
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String salvar(){
        usuarioService.salvar(usuario);
        usuario = new Usuario();
        return null;
    }
}
