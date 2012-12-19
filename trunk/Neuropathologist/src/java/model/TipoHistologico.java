/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcelo
 */
@Entity
@Table(name = "tipo_histologico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoHistologico.findAll", query = "SELECT t FROM TipoHistologico t"),
    @NamedQuery(name = "TipoHistologico.findById", query = "SELECT t FROM TipoHistologico t WHERE t.id = :id"),
    @NamedQuery(name = "TipoHistologico.findByDescricao", query = "SELECT t FROM TipoHistologico t WHERE t.descricao = :descricao")})
public class TipoHistologico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao")
    private String descricao;

    public TipoHistologico() {
    }

    public TipoHistologico(Integer id) {
        this.id = id;
    }

    public TipoHistologico(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof TipoHistologico)) {
            return false;
        }
        TipoHistologico other = (TipoHistologico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoHistologico[ id=" + id + " ]";
    }
    
}
