/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.id = :id"),
    @NamedQuery(name = "Paciente.findByRegistro", query = "SELECT p FROM Paciente p WHERE p.registro = :registro"),
    @NamedQuery(name = "Paciente.findByDataNascimento", query = "SELECT p FROM Paciente p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "registro")
    private String registro;
    @Size(max = 100)
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteId")
    private Collection<Procedimento> procedimentoCollection;

    public Paciente() {
    }

    public Paciente(Integer id) {
        this.id = id;
    }

    public Paciente(Integer id, String registro) {
        this.id = id;
        this.registro = registro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public Collection<Procedimento> getProcedimentoCollection() {
        return procedimentoCollection;
    }

    public void setProcedimentoCollection(Collection<Procedimento> procedimentoCollection) {
        this.procedimentoCollection = procedimentoCollection;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Paciente[ id=" + id + " ]";
    }
    
}
