/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean.utils;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author marcelo
 */


@Named(value = "msg")
@SessionScoped
public class Msg implements Serializable{

    //private Mensagem mensagem;

    public Msg() {
        //this.mensagem = new Mensagem("Bundle", new Locale("en", "US"));
    }

    public void addSuccess(String msg){
        //String msg = this.mensagem.getValue(key);
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("msgs");
    }

    public void addErro(String msg){
        //String msg = this.mensagem.getValue(key);
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("msgs");
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("msgs");
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("msgs");
    }
}
