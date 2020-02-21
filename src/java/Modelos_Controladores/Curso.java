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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByCodCurso", query = "SELECT c FROM Curso c WHERE c.codCurso = :codCurso")
    , @NamedQuery(name = "Curso.findByNomCurso", query = "SELECT c FROM Curso c WHERE c.nomCurso = :nomCurso")
    , @NamedQuery(name = "Curso.findByHoraCurso", query = "SELECT c FROM Curso c WHERE c.horaCurso = :horaCurso")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_curso")
    private Integer codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_curso")
    private String nomCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hora_curso")
    private String horaCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoCodCurso")
    private Collection<AsignacionCursos> asignacionCursosCollection;

    public Curso() {
    }

    public Curso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Curso(Integer codCurso, String nomCurso, String horaCurso) {
        this.codCurso = codCurso;
        this.nomCurso = nomCurso;
        this.horaCurso = horaCurso;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public String getHoraCurso() {
        return horaCurso;
    }

    public void setHoraCurso(String horaCurso) {
        this.horaCurso = horaCurso;
    }

    @XmlTransient
    public Collection<AsignacionCursos> getAsignacionCursosCollection() {
        return asignacionCursosCollection;
    }

    public void setAsignacionCursosCollection(Collection<AsignacionCursos> asignacionCursosCollection) {
        this.asignacionCursosCollection = asignacionCursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos_Controladores.Curso[ codCurso=" + codCurso + " ]";
    }
    
}
