package com.mycompany.models;
// Generated Sep 8, 2015 3:54:08 PM by Hibernate Tools 4.3.1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductoEnVenta generated by hbm2java
 */
@Entity
@Table(name="ProductosEnVenta")
public class ProductoEnVenta  implements java.io.Serializable {


     private int idProductosEnVenta;
     private Campesino campesinos;
     private Producto productos;
     private String descripcion;
     private Date fechaCosecha;
     private float cantidadDisponible;
     private int precioPorKg;
     private byte[] foto;
     private Set<DetalleFactura> detalleFacturas = new HashSet<DetalleFactura>(0);

    public ProductoEnVenta() {
    }

	
    public ProductoEnVenta(int idProductosEnVenta, Campesino campesinos, Producto productos, String descripcion, Date fechaCosecha, float cantidadDisponible, int precioPorKg) {
        this.idProductosEnVenta = idProductosEnVenta;
        this.campesinos = campesinos;
        this.productos = productos;
        this.descripcion = descripcion;
        this.fechaCosecha = fechaCosecha;
        this.cantidadDisponible = cantidadDisponible;
        this.precioPorKg = precioPorKg;
    }
    public ProductoEnVenta(int idProductosEnVenta, Campesino campesinos, Producto productos, String descripcion, Date fechaCosecha, float cantidadDisponible, int precioPorKg, byte[] foto, Set<DetalleFactura> detalleFacturas) {
       this.idProductosEnVenta = idProductosEnVenta;
       this.campesinos = campesinos;
       this.productos = productos;
       this.descripcion = descripcion;
       this.fechaCosecha = fechaCosecha;
       this.cantidadDisponible = cantidadDisponible;
       this.precioPorKg = precioPorKg;
       this.foto = foto;
       this.detalleFacturas = detalleFacturas;
    }
   
     @Id 

    
    @Column(name="idProductosEnVenta", unique=true, nullable=false)
    public int getIdProductosEnVenta() {
        return this.idProductosEnVenta;
    }
    
    public void setIdProductosEnVenta(int idProductosEnVenta) {
        this.idProductosEnVenta = idProductosEnVenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Campesinos_idCampesinos", nullable=false)
    public Campesino getCampesinos() {
        return this.campesinos;
    }
    
    public void setCampesinos(Campesino campesinos) {
        this.campesinos = campesinos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Productos_idProductos", nullable=false)
    public Producto getProductos() {
        return this.productos;
    }
    
    public void setProductos(Producto productos) {
        this.productos = productos;
    }

    
    @Column(name="descripcion", nullable=false, length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechaCosecha", nullable=false, length=10)
    public Date getFechaCosecha() {
        return this.fechaCosecha;
    }
    
    public void setFechaCosecha(Date fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
    }

    
    @Column(name="cantidadDisponible", nullable=false, precision=12, scale=0)
    public float getCantidadDisponible() {
        return this.cantidadDisponible;
    }
    
    public void setCantidadDisponible(float cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    
    @Column(name="precioPorKG", nullable=false)
    public int getPrecioPorKg() {
        return this.precioPorKg;
    }
    
    public void setPrecioPorKg(int precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

    
    @Column(name="foto")
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productosEnVenta")
    public Set<DetalleFactura> getDetalleFacturas() {
        return this.detalleFacturas;
    }
    
    public void setDetalleFacturas(Set<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }




}


