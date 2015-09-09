package com.mycompany.models;
// Generated Sep 8, 2015 3:54:08 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Despacho generated by hbm2java
 */
@Entity
@Table(name="Despachos")
public class Despacho  implements java.io.Serializable {


     private int idDespachos;
     private DetalleFactura detalleFactura;
     private Ruta rutas;
     private Date estimacionRecoleccion;
     private Date estimacionEntrega;

    public Despacho() {
    }

    public Despacho(int idDespachos, DetalleFactura detalleFactura, Ruta rutas, Date estimacionRecoleccion, Date estimacionEntrega) {
       this.idDespachos = idDespachos;
       this.detalleFactura = detalleFactura;
       this.rutas = rutas;
       this.estimacionRecoleccion = estimacionRecoleccion;
       this.estimacionEntrega = estimacionEntrega;
    }
   
     @Id 

    
    @Column(name="idDespachos", unique=true, nullable=false)
    public int getIdDespachos() {
        return this.idDespachos;
    }
    
    public void setIdDespachos(int idDespachos) {
        this.idDespachos = idDespachos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="DetalleFactura_ProductosEnVenta_idProductosEnVenta", referencedColumnName="ProductosEnVenta_idProductosEnVenta", nullable=false), 
        @JoinColumn(name="DetalleFactura_Facturas_idFacturas", referencedColumnName="Facturas_idFacturas", nullable=false) } )
    public DetalleFactura getDetalleFactura() {
        return this.detalleFactura;
    }
    
    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Rutas_idRutas", nullable=false)
    public Ruta getRutas() {
        return this.rutas;
    }
    
    public void setRutas(Ruta rutas) {
        this.rutas = rutas;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="estimacionRecoleccion", nullable=false, length=10)
    public Date getEstimacionRecoleccion() {
        return this.estimacionRecoleccion;
    }
    
    public void setEstimacionRecoleccion(Date estimacionRecoleccion) {
        this.estimacionRecoleccion = estimacionRecoleccion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="estimacionEntrega", nullable=false, length=10)
    public Date getEstimacionEntrega() {
        return this.estimacionEntrega;
    }
    
    public void setEstimacionEntrega(Date estimacionEntrega) {
        this.estimacionEntrega = estimacionEntrega;
    }




}


