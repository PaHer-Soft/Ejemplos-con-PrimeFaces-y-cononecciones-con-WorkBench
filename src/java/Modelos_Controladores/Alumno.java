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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByCodAlumno", query = "SELECT a FROM Alumno a WHERE a.codAlumno = :codAlumno")
    , @NamedQuery(name = "Alumno.findByNomAlumno", query = "SELECT a FROM Alumno a WHERE a.nomAlumno = :nomAlumno")
    , @NamedQuery(name = "Alumno.findByApellAlumno", query = "SELECT a FROM Alumno a WHERE a.apellAlumno = :apellAlumno")
    , @NamedQuery(name = "Alumno.findByTelAlumno", query = "SELECT a FROM Alumno a WHERE a.telAlumno = :telAlumno")
    , @NamedQuery(name = "Alumno.findByDirecAlumno", query = "SELECT a FROM Alumno a WHERE a.direcAlumno = :direcAlumno")
    , @NamedQuery(name = "Alumno.findByCorreoAlumno", query = "SELECT a FROM Alumno a WHERE a.correoAlumno = :correoAlumno")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_alumno")
    private Integer codAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_alumno")
    private String nomAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apell_alumno")
    private String apellAlumno;
    @Size(max = 45)
    @Column(name = "tel_alumno")
    private String telAlumno;
    @Size(max = 45)
    @Column(name = "direc_alumno")
    private String direcAlumno;
    @Size(max = 45)
    @Column(name = "correo_alumno")
    private String correoAlumno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnoCodAlumno")
    private Collection<Inscripcion> inscripcionCollection;
    @JoinColumn(name = "genero_cod_genero", referencedColumnName = "cod_genero")
    @ManyToOne(optional = false)
    private Genero generoCodGenero;

    public Alumno() {
    }

    public Alumno(Integer codAlumno) {
        this.codAlumno = codAlumno;
    }

    public Alumno(Integer codAlumno, String nomAlumno, String apellAlumno) {
        this.codAlumno = codAlumno;
        this.nomAlumno = nomAlumno;
        this.apellAlumno = apellAlumno;
    }

    public Integer getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(Integer codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getNomAlumno() {
        return nomAlumno;
    }

    public void setNomAlumno(String nomAlumno) {
        this.nomAlumno = nomAlumno;
    }

    public String getApellAlumno() {
        return apellAlumno;
    }

    public void setApellAlumno(String apellAlumno) {
        this.apellAlumno = apellAlumno;
    }

    public String getTelAlumno() {
        return telAlumno;
    }

    public void setTelAlumno(String telAlumno) {
        this.telAlumno = telAlumno;
    }

    public String getDirecAlumno() {
        return direcAlumno;
    }

    public void setDirecAlumno(String direcAlumno) {
        this.direcAlumno = direcAlumno;
    }

    public String getCorreoAlumno() {
        return correoAlumno;
    }

    public void setCorreoAlumno(String correoAlumno) {
        this.correoAlumno = correoAlumno;
    }

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    public Genero getGeneroCodGenero() {
        return generoCodGenero;
    }

    public void setGeneroCodGenero(Genero generoCodGenero) {
        this.generoCodGenero = generoCodGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos_Controladores.Alumno[ codAlumno=" + codAlumno + " ]";
    }
    
}
