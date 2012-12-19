/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import managedbean.utils.Msg;
import model.Grupo;
import service.GrupoService;

/**
 *
 * @author marcelo
 */
@Named(value = "grupoMB")
@SessionScoped
public class GrupoMB implements Serializable{
    @Inject
    private GrupoService grupoService;
    @Inject
    private Msg msg;
    private Grupo grupo;

    /**
     * Creates a new instance of GrupoMB
     */
    public GrupoMB() {
    }

    @PostConstruct 
    public void init(){
        grupo = new Grupo();
    }
    public Grupo getGrupo() {
//        if(grupo == null){
//            grupo = new Grupo();
//        }
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    public String salvar(){
        grupoService.salvar(getGrupo());
        grupo = new Grupo();
        //msg.addSuccess("Grupo adicionado com sucesso");
        msg.teste("Nome");
        return null;
    }

    
    
}
