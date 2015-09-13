/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.mycompany.models.Campesino;
import com.mycompany.models.Producto;
import com.mycompany.models.ProductoEnVenta;
import com.mycompany.models.Transportista;
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
    
    /**
     * Consulta el Id de las rutas que tiene que recorrer un transportista en determinada fecha
     * @param s Sesion de la base de datos
     * @param t Transportista al que se le quiere consultar las rutas
     * @param d Fecha en la que se quieren consultar las rutas
     * @return Una lista con el Id de las rutas 
     */
    public static List<Integer> rutasPorTransportista(Session s, Transportista t, Date d){
         
        Query q2 = s.createQuery("SELECT r.idRutas FROM Ruta r WHERE r.fechaInicio=:fechaID AND r.transportistas.idTransportistas= :transportistaID");
        q2.setParameter("transportistaID", t.getIdTransportistas());
        q2.setParameter("fechaID", d);
        List<Integer> rutas = q2.list();
        
        return rutas;
    }
    
    /**
     * Consulta el nombre de los productos que tiene que recoger un transportista en determinada fecha
     * @param s Sesion de la base de datos
     * @param t Transportista al que se le quiere consultar las rutas
     * @param d Fecha en la que se quieren consultar las rutas
     * @return Una lista con el nombre de las productos
     */
    public static List<Integer> productosPorFecha(Session s, Transportista t, Date d){
        
        Query q = s.createQuery("SELECT p.productos.nombre FROM ProductoEnVenta p WHERE p.idProductosEnVenta in "
                + "(SELECT d.detalleFactura.productosEnVenta.idProductosEnVenta FROM Despacho d WHERE d.rutas.transportistas.idTransportistas= :transportistaID AND d.rutas.fechaInicio=:fechaID)");
        q.setParameter("transportistaID", t.getIdTransportistas());
        q.setParameter("fechaID", d);
        List<Integer> productos = q.list();
        return productos;
    }
    
}
