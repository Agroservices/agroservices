package com.mycompany.models;
// Generated Sep 8, 2015 3:54:08 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name="Productos")
public class Producto  implements java.io.Serializable {


     private int idProductos;
     private String nombre;
     private int duracion;
     private boolean refrigeracion;
     private Set<ProductoEnVenta> productosEnVentas = new HashSet<ProductoEnVenta>(0);

    public Producto() {
    }

	
    public Producto(int idProductos, String nombre, int duracion, boolean refrigeracion) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.duracion = duracion;
        this.refrigeracion = refrigeracion;
    }
    public Producto(int idProductos, String nombre, int duracion, boolean refrigeracion, Set<ProductoEnVenta> productosEnVentas) {
       this.idProductos = idProductos;
       this.nombre = nombre;
       this.duracion = duracion;
       this.refrigeracion = refrigeracion;
       this.productosEnVentas = productosEnVentas;
    }
   
     @Id 

    
    @Column(name="idProductos", unique=true, nullable=false)
    public int getIdProductos() {
        return this.idProductos;
    }
    
    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="duracion", nullable=false)
    public int getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
    @Column(name="refrigeracion", nullable=false)
    public boolean isRefrigeracion() {
        return this.refrigeracion;
    }
    
    public void setRefrigeracion(boolean refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productos")
    public Set<ProductoEnVenta> getProductosEnVentas() {
        return this.productosEnVentas;
    }
    
    public void setProductosEnVentas(Set<ProductoEnVenta> productosEnVentas) {
        this.productosEnVentas = productosEnVentas;
    }




}


