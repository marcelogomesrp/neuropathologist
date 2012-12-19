/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marcelo
 */
@Embeddable
public class DiagnosticoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "procedimento_id")
    private int procedimentoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private int usuarioId;

    public DiagnosticoPK() {
    }

    public DiagnosticoPK(int procedimentoId, int usuarioId) {
        this.procedimentoId = procedimentoId;
        this.usuarioId = usuarioId;
    }

    public int getProcedimentoId() {
        return procedimentoId;
    }

    public void setProcedimentoId(int procedimentoId) {
        this.procedimentoId = procedimentoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) procedimentoId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoPK)) {
            return false;
        }
        DiagnosticoPK other = (DiagnosticoPK) object;
        if (this.procedimentoId != other.procedimentoId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DiagnosticoPK[ procedimentoId=" + procedimentoId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
