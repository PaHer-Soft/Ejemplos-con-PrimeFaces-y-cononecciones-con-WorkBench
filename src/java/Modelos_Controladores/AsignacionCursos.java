/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos_Controladores;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "asignacion_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionCursos.findAll", query = "SELECT a FROM AsignacionCursos a")
    , @NamedQuery(name = "AsignacionCursos.findByCodAsigCurso", query = "SELECT a FROM AsignacionCursos a WHERE a.codAsigCurso = :codAsigCurso")})
public class AsignacionCursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_asig_curso")
    private Integer codAsigCurso;
    @JoinColumn(name = "curso_cod_curso", referencedColumnName = "cod_curso")
    @ManyToOne(optional = false)
    private Curso cursoCodCurso;
    @JoinColumn(name = "inscripcion_cod_inscripcion", referencedColumnName = "cod_inscripcion")
    @ManyToOne(optional = false)
    private Inscripcion inscripcionCodInscripcion;

    public AsignacionCursos() {
    }

    public AsignacionCursos(Integer codAsigCurso) {
        this.codAsigCurso = codAsigCurso;
    }

    public Integer getCodAsigCurso() {
        return codAsigCurso;
    }

    public void setCodAsigCurso(Integer codAsigCurso) {
        this.codAsigCurso = codAsigCurso;
    }

    public Curso getCursoCodCurso() {
        return cursoCodCurso;
    }

    public void setCursoCodCurso(Curso cursoCodCurso) {
        this.cursoCodCurso = cursoCodCurso;
    }

    public Inscripcion getInscripcionCodInscripcion() {
        return inscripcionCodInscripcion;
    }

    public void setInscripcionCodInscripcion(Inscripcion inscripcionCodInscripcion) {
        this.inscripcionCodInscripcion = inscripcionCodInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAsigCurso != null ? codAsigCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionCursos)) {
            return false;
        }
        AsignacionCursos other = (AsignacionCursos) object;
        if ((this.codAsigCurso == null && other.codAsigCurso != null) || (this.codAsigCurso != null && !this.codAsigCurso.equals(other.codAsigCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos_Controladores.AsignacionCursos[ codAsigCurso=" + codAsigCurso + " ]";
    }
    
}
