/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agroservices_12_09_15;

import com.mycompany.models.Campesino;
import com.mycompany.models.Producto;
import com.mycompany.models.ProductoEnVenta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author laboratorio
 */
public class PersistenceFacade {
    
    
    public static List<Campesino> campesinosPorProducto(Session s, Producto p, float cantidad){
        
        Query q = s.createQuery("SELECT p FROM ProductoEnVenta p where p.productos.idProductos= :productoID and p.cantidadDisponible > :cantidad");
        
        q.setParameter("productoID", p.getIdProductos());
        q.setParameter("cantidad", cantidad);
        
        List<ProductoEnVenta> productos = q.list();
        
        List<Campesino> respuesta =  new ArrayList<>(0);
        Calendar gc = GregorianCalendar.getInstance();
        
        Date ds = new Date(System.currentTimeMillis());
        System.out.println(ds.getYear()+" "+ds.getMonth()+" "+ds.getDate());
        
        Date sumada = null;
        for (ProductoEnVenta pev : productos){
            Date date = pev.getFechaCosecha();
            gc.set(date.getYear()+1900, date.getMonth(), date.getDay());
            gc.add(GregorianCalendar.DAY_OF_MONTH, pev.getProductos().getDuracion());
            
            sumada = gc.getTime();
           
            if(ds.before(sumada)){
                respuesta.add(pev.getCampesinos());
            }

        }
        
             
       
        return respuesta;
        
    }
    
}
