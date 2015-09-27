package com.mycompany.models;


// Generated 12/09/2015 04:52:35 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Rutas generated by hbm2java
 */

@NamedQueries({
    @NamedQuery(name="rutaTransportista",
            query="SELECT r.idRutas FROM Ruta r WHERE r.fechaInicio=:fechaID AND "
                    + "r.transportistas.idTransportistas= :transportistaID")
})

@Entity
@Table(name="Rutas")
public class Ruta  implements java.io.Serializable {


     private Integer idRutas;
     private Transportista transportistas;
     private Date fechaInicio;
     private Date fechaFinalizacion;
     private Set <Despacho>despachoses = new HashSet<Despacho>(0);
     private Set <Novedad>novedadeses = new HashSet<Novedad>(0);

    public Ruta() {
    }

	
    public Ruta(Transportista transportistas, Date fechaInicio, Date fechaFinalizacion) {
        this.transportistas = transportistas;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    public Ruta(Transportista transportistas, Date fechaInicio, Date fechaFinalizacion, Set <Despacho>despachoses, Set <Novedad>novedadeses) {
       this.transportistas = transportistas;
       this.fechaInicio = fechaInicio;
       this.fechaFinalizacion = fechaFinalizacion;
       this.despachoses = despachoses;
       this.novedadeses = novedadeses;
    }
   
     @Id @GeneratedValue

    
    @Column(name="idRutas", unique=true, nullable=false)
    public Integer getIdRutas() {
        return this.idRutas;
    }
    
    public void setIdRutas(Integer idRutas) {
        this.idRutas = idRutas;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Transportistas_idTransportistas", nullable=false)
    public Transportista getTransportistas() {
        return this.transportistas;
    }
    
    public void setTransportistas(Transportista transportistas) {
        this.transportistas = transportistas;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaInicio", nullable=false, length=10)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaFinalizacion", nullable=false, length=10)
    public Date getFechaFinalizacion() {
        return this.fechaFinalizacion;
    }
    
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rutas")
    public Set <Despacho>getDespachoses() {
        return this.despachoses;
    }
    
    public void setDespachoses(Set <Despacho>despachoses) {
        this.despachoses = despachoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rutas")
    public Set <Novedad>getNovedadeses() {
        return this.novedadeses;
    }
    
    public void setNovedadeses(Set <Novedad>novedadeses) {
        this.novedadeses = novedadeses;
    }




}


