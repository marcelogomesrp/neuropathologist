/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByProcedimentoId", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoPK.procedimentoId = :procedimentoId"),
    @NamedQuery(name = "Diagnostico.findByUsuarioId", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "Diagnostico.findByTipoHistologicoId", query = "SELECT d FROM Diagnostico d WHERE d.tipoHistologicoId = :tipoHistologicoId")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticoPK diagnosticoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_histologico_id")
    private int tipoHistologicoId;

    public Diagnostico() {
    }

    public Diagnostico(DiagnosticoPK diagnosticoPK) {
        this.diagnosticoPK = diagnosticoPK;
    }

    public Diagnostico(DiagnosticoPK diagnosticoPK, int tipoHistologicoId) {
        this.diagnosticoPK = diagnosticoPK;
        this.tipoHistologicoId = tipoHistologicoId;
    }

    public Diagnostico(int procedimentoId, int usuarioId) {
        this.diagnosticoPK = new DiagnosticoPK(procedimentoId, usuarioId);
    }

    public DiagnosticoPK getDiagnosticoPK() {
        return diagnosticoPK;
    }

    public void setDiagnosticoPK(DiagnosticoPK diagnosticoPK) {
        this.diagnosticoPK = diagnosticoPK;
    }

    public int getTipoHistologicoId() {
        return tipoHistologicoId;
    }

    public void setTipoHistologicoId(int tipoHistologicoId) {
        this.tipoHistologicoId = tipoHistologicoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoPK != null ? diagnosticoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.diagnosticoPK == null && other.diagnosticoPK != null) || (this.diagnosticoPK != null && !this.diagnosticoPK.equals(other.diagnosticoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Diagnostico[ diagnosticoPK=" + diagnosticoPK + " ]";
    }
    
}
