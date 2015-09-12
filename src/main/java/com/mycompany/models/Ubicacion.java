package com.mycompany.models;


// Generated 12/09/2015 04:52:35 PM by Hibernate Tools 4.3.1


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

/**
 * Ubicaciones generated by hbm2java
 */
@Entity
@Table(name="Ubicaciones")
public class Ubicacion  implements java.io.Serializable {


     private Integer idUbicaciones;
     private Minorista minoristas;
     private Transportista transportistas;
     private String direccion;
     private String ciudad;
     private String departamento;
     private String longitud;
     private String latitud;
     private String descripcion;
     private Set <Factura>facturases = new HashSet<Factura>(0);
     private Set <Campesino>campesinoses = new HashSet<Campesino>(0);

    public Ubicacion() {
    }

	
    public Ubicacion(String direccion, String ciudad, String departamento, String longitud, String latitud) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    public Ubicacion(Minorista minoristas, Transportista transportistas, String direccion, String ciudad, String departamento, String longitud, String latitud, String descripcion, Set <Factura>facturases, Set <Campesino>campesinoses) {
       this.minoristas = minoristas;
       this.transportistas = transportistas;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.departamento = departamento;
       this.longitud = longitud;
       this.latitud = latitud;
       this.descripcion = descripcion;
       this.facturases = facturases;
       this.campesinoses = campesinoses;
    }
   
     @Id @GeneratedValue

    
    @Column(name="idUbicaciones", unique=true, nullable=false)
    public Integer getIdUbicaciones() {
        return this.idUbicaciones;
    }
    
    public void setIdUbicaciones(Integer idUbicaciones) {
        this.idUbicaciones = idUbicaciones;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Minoristas_idMinoristas")
    public Minorista getMinoristas() {
        return this.minoristas;
    }
    
    public void setMinoristas(Minorista minoristas) {
        this.minoristas = minoristas;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Transportistas_idTransportistas")
    public Transportista getTransportistas() {
        return this.transportistas;
    }
    
    public void setTransportistas(Transportista transportistas) {
        this.transportistas = transportistas;
    }

    
    @Column(name="direccion", nullable=false, length=50)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="ciudad", nullable=false, length=20)
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    @Column(name="departamento", nullable=false, length=20)
    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    
    @Column(name="longitud", nullable=false, length=45)
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    
    @Column(name="latitud", nullable=false, length=45)
    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    
    @Column(name="descripcion", length=200)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ubicaciones")
    public Set <Factura>getFacturases() {
        return this.facturases;
    }
    
    public void setFacturases(Set <Factura>facturases) {
        this.facturases = facturases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ubicaciones")
    public Set <Campesino>getCampesinoses() {
        return this.campesinoses;
    }
    
    public void setCampesinoses(Set <Campesino>campesinoses) {
        this.campesinoses = campesinoses;
    }




}


