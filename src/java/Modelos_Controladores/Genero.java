/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos_Controladores;

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
 * @author Patrick
 */
@Entity
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g")
    , @NamedQuery(name = "Genero.findByCodGenero", query = "SELECT g FROM Genero g WHERE g.codGenero = :codGenero")
    , @NamedQuery(name = "Genero.findByDescripGenero", query = "SELECT g FROM Genero g WHERE g.descripGenero = :descripGenero")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_genero")
    private Integer codGenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descrip_genero")
    private String descripGenero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generoCodGenero")
    private Collection<Alumno> alumnoCollection;

    public Genero() {
    }

    public Genero(Integer codGenero) {
        this.codGenero = codGenero;
    }

    public Genero(Integer codGenero, String descripGenero) {
        this.codGenero = codGenero;
        this.descripGenero = descripGenero;
    }

    public Integer getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(Integer codGenero) {
        this.codGenero = codGenero;
    }

    public String getDescripGenero() {
        return descripGenero;
    }

    public void setDescripGenero(String descripGenero) {
        this.descripGenero = descripGenero;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGenero != null ? codGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.codGenero == null && other.codGenero != null) || (this.codGenero != null && !this.codGenero.equals(other.codGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos_Controladores.Genero[ codGenero=" + codGenero + " ]";
    }
    
}
