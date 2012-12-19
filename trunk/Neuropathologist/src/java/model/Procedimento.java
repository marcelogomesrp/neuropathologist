/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "procedimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimento.findAll", query = "SELECT p FROM Procedimento p"),
    @NamedQuery(name = "Procedimento.findById", query = "SELECT p FROM Procedimento p WHERE p.id = :id"),
    @NamedQuery(name = "Procedimento.findByNumBiopsia", query = "SELECT p FROM Procedimento p WHERE p.numBiopsia = :numBiopsia"),
    @NamedQuery(name = "Procedimento.findByDataCirurgia", query = "SELECT p FROM Procedimento p WHERE p.dataCirurgia = :dataCirurgia"),
    @NamedQuery(name = "Procedimento.findByTipoProcedimento", query = "SELECT p FROM Procedimento p WHERE p.tipoProcedimento = :tipoProcedimento"),
    @NamedQuery(name = "Procedimento.findByMaterialCongelado", query = "SELECT p FROM Procedimento p WHERE p.materialCongelado = :materialCongelado"),
    @NamedQuery(name = "Procedimento.findByMicrodisseccao", query = "SELECT p FROM Procedimento p WHERE p.microdisseccao = :microdisseccao")})
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "num_biopsia")
    private String numBiopsia;
    @Column(name = "data_cirurgia")
    @Temporal(TemporalType.DATE)
    private Date dataCirurgia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tipo_procedimento")
    private String tipoProcedimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_congelado")
    private boolean materialCongelado;
    @Column(name = "microdisseccao")
    private Boolean microdisseccao;
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paciente pacienteId;

    public Procedimento() {
    }

    public Procedimento(Integer id) {
        this.id = id;
    }

    public Procedimento(Integer id, String numBiopsia, String tipoProcedimento, boolean materialCongelado) {
        this.id = id;
        this.numBiopsia = numBiopsia;
        this.tipoProcedimento = tipoProcedimento;
        this.materialCongelado = materialCongelado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumBiopsia() {
        return numBiopsia;
    }

    public void setNumBiopsia(String numBiopsia) {
        this.numBiopsia = numBiopsia;
    }

    public Date getDataCirurgia() {
        return dataCirurgia;
    }

    public void setDataCirurgia(Date dataCirurgia) {
        this.dataCirurgia = dataCirurgia;
    }

    public String getTipoProcedimento() {
        return tipoProcedimento;
    }

    public void setTipoProcedimento(String tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    public boolean getMaterialCongelado() {
        return materialCongelado;
    }

    public void setMaterialCongelado(boolean materialCongelado) {
        this.materialCongelado = materialCongelado;
    }

    public Boolean getMicrodisseccao() {
        return microdisseccao;
    }

    public void setMicrodisseccao(Boolean microdisseccao) {
        this.microdisseccao = microdisseccao;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimento)) {
            return false;
        }
        Procedimento other = (Procedimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Procedimento[ id=" + id + " ]";
    }
    
}
