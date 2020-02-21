/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos_Controladores;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")
    , @NamedQuery(name = "Inscripcion.findByCodInscripcion", query = "SELECT i FROM Inscripcion i WHERE i.codInscripcion = :codInscripcion")
    , @NamedQuery(name = "Inscripcion.findByFechaInscripcion", query = "SELECT i FROM Inscripcion i WHERE i.fechaInscripcion = :fechaInscripcion")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_inscripcion")
    private Integer codInscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionCodInscripcion")
    private Collection<AsignacionCursos> asignacionCursosCollection;
    @JoinColumn(name = "alumno_cod_alumno", referencedColumnName = "cod_alumno")
    @ManyToOne(optional = false)
    private Alumno alumnoCodAlumno;

    public Inscripcion() {
    }

    public Inscripcion(Integer codInscripcion) {
        this.codInscripcion = codInscripcion;
    }

    public Inscripcion(Integer codInscripcion, Date fechaInscripcion) {
        this.codInscripcion = codInscripcion;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getCodInscripcion() {
        return codInscripcion;
    }

    public void setCodInscripcion(Integer codInscripcion) {
        this.codInscripcion = codInscripcion;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @XmlTransient
    public Collection<AsignacionCursos> getAsignacionCursosCollection() {
        return asignacionCursosCollection;
    }

    public void setAsignacionCursosCollection(Collection<AsignacionCursos> asignacionCursosCollection) {
        this.asignacionCursosCollection = asignacionCursosCollection;
    }

    public Alumno getAlumnoCodAlumno() {
        return alumnoCodAlumno;
    }

    public void setAlumnoCodAlumno(Alumno alumnoCodAlumno) {
        this.alumnoCodAlumno = alumnoCodAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInscripcion != null ? codInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.codInscripcion == null && other.codInscripcion != null) || (this.codInscripcion != null && !this.codInscripcion.equals(other.codInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos_Controladores.Inscripcion[ codInscripcion=" + codInscripcion + " ]";
    }
    
}
