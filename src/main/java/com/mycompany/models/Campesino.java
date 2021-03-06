package com.mycompany.models;


// Generated 12/09/2015 04:52:35 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Campesinos generated by hbm2java
 */
@Entity
@Table(name="Campesinos")
public class Campesino  implements java.io.Serializable {


     private int idCampesinos;
     private Ubicacion ubicaciones;
     private String nombres;
     private String apellidos;
     private String telefono;
     private String correo;
     private Set<ProductoEnVenta> productosEnVentas = new HashSet<ProductoEnVenta>(0);

    public Campesino() {
    }

	
    public Campesino(int idCampesinos, Ubicacion ubicaciones, String nombres, String apellidos, String telefono) {
        this.idCampesinos = idCampesinos;
        this.ubicaciones = ubicaciones;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    public Campesino(int idCampesinos, Ubicacion ubicaciones, String nombres, String apellidos, String telefono, String correo, Set <ProductoEnVenta>productosEnVentas) {
       this.idCampesinos = idCampesinos;
       this.ubicaciones = ubicaciones;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.telefono = telefono;
       this.correo = correo;
       this.productosEnVentas = productosEnVentas;
    }
   
     @Id 

    
    @Column(name="idCampesinos", unique=true, nullable=false)
    public int getIdCampesinos() {
        return this.idCampesinos;
    }
    
    public void setIdCampesinos(int idCampesinos) {
        this.idCampesinos = idCampesinos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Ubicaciones_idUbicaciones", nullable=false)
    public Ubicacion getUbicaciones() {
        return this.ubicaciones;
    }
    
    public void setUbicaciones(Ubicacion ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    
    @Column(name="nombres", nullable=false, length=45)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    @Column(name="apellidos", nullable=false, length=45)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    @Column(name="telefono", nullable=false, length=10)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="correo", length=45)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="campesinos")
    public Set <ProductoEnVenta>getProductosEnVentas() {
        return this.productosEnVentas;
    }
    
    public void setProductosEnVentas(Set <ProductoEnVenta>productosEnVentas) {
        this.productosEnVentas = productosEnVentas;
    }




}


