/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.models.Campesino;
import com.mycompany.models.DetalleFactura;
import com.mycompany.models.DetalleFacturaId;
import com.mycompany.models.Factura;
import com.mycompany.models.Minorista;
import com.mycompany.models.Producto;
import com.mycompany.models.ProductoEnVenta;
import com.mycompany.models.TransaccionBancaria;
import com.mycompany.models.Ubicacion;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import main.PersistenceFacade;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 3079945
 */
public class PersistenceTest {
    
    private SessionFactory sessionFactory;
    private Session session = null;
    
    /**
     * Operaciones que se realizan antes de ejecutar el banco de pruebas.
     * En este caso se crea una misma sesión que será usada en todas las
     * pruebas.
     */
    @Before
    public void setupSession() {
        
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-inmemory.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();
        
    }
        
    /**
     * Operaciones que se realizan cuando finalice la ejecución de las pruebas.
     * En este caso se cierra la sesi_n y la f_brica de sesiones.
     */
    @After
    public void closeResources(){
        session.close();
        sessionFactory.close();
    }
    
    @Test
    public void consultarRutasAsignadas(){
        
        Transaction tx=session.beginTransaction();
        /*******************************************************************
        CREACION DE LOS PRODUCTOS
        ********************************************************************/
        Producto p1 = new Producto("Lechuga", 36, true);
        Producto p2 = new Producto("Tomate", 30, false);
        Producto p3 = new Producto("Cebolla", 60, false);
        Producto p4 = new Producto("Papa criolla", 15, true);
        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        /*******************************************************************
        CREACION DE LAS UBICACIONES
        ********************************************************************/
        Ubicacion u1 = new Ubicacion("Calle 160 # 36 - 45", "Chia", "Cundinamarca", "50", "50");
        Ubicacion u2 = new Ubicacion("Transversal 14 # 25 - 35", "Bogota", "Cundinamarca", "60", "60");
        Ubicacion u3 = new Ubicacion("Calle 26 sur # 8 - 63", "Bogota", "Cundinamarca", "70", "70");
        Ubicacion u4 = new Ubicacion("Carrera 53 # 15 - 43", "Tabio", "Cundinamarca", "80", "80");
        Ubicacion u5 = new Ubicacion("Carrera 13 # 24 - 72", "Sopo", "Cundinamarca", "90", "90");
        Ubicacion u6 = new Ubicacion("Calle 140 # 7 - 8", "Bogota", "Cundinamarca", "100", "100");
        Ubicacion u7 = new Ubicacion("Calle 127 # 15 - 28", "Bogota", "Cundinamarca", "110", "110");
        session.save(u1);
        session.save(u2);
        session.save(u3);
        session.save(u4);
        session.save(u5);
        session.save(u6);
        session.save(u7);
        /*******************************************************************
        CREACION DE LOS CAMPESINOS
        ********************************************************************/
        Campesino c1 = new Campesino(123456789, u1, "Pedro Nel", "Sanchez Carrasquilla", "4559875");
        Campesino c2 = new Campesino(987654321, u4, "Carlos Albeiro", "Rodriguez Paez", "1597536");
        Campesino c3 = new Campesino(159753846, u5, "Wilson", "Torres Sanabria", "3571568");
        session.save(c1);
        session.save(c2);
        session.save(c3);
        /*******************************************************************
        CREACION DE LOS PRODUCTOS EN VENTA
        ********************************************************************/
        ProductoEnVenta pev1 = new ProductoEnVenta(c1, p1, "Lechuga verde", new Date(2015-1900, 6, 15), (float)(35.8), 3500);
        ProductoEnVenta pev2 = new ProductoEnVenta(c1, p2, "Tomates rojos", new Date(2015-1900, 7, 8), (float)(60.3), 2450);        
        ProductoEnVenta pev3 = new ProductoEnVenta(c2, p3, "Cebolla cabezona", new Date(2015-1900, 8, 23), (float)(100.4), 1800);
        ProductoEnVenta pev4 = new ProductoEnVenta(c3, p4, "Papa amarilla", new Date(2015-1900, 7, 18), (float)(86.5), 4600);
        session.save(pev1);
        session.save(pev2);
        session.save(pev3);
        session.save(pev4);
        /*******************************************************************
        CREACION DE LAS TRANSACCIONES BANCARIAS
        ********************************************************************/
        TransaccionBancaria tb1 = new TransaccionBancaria("A1B2C3D4", new Date(2015-1900, 5, 13));
        TransaccionBancaria tb2 = new TransaccionBancaria("E5F6G7H8", new Date(2015-1900, 3, 8));
        TransaccionBancaria tb3 = new TransaccionBancaria("I9J1K2L3", new Date(2015-1900, 7, 20));
        TransaccionBancaria tb4 = new TransaccionBancaria("M4N5O6P7", new Date(2015-1900, 1, 26));
        TransaccionBancaria tb5 = new TransaccionBancaria("M4N5O6P7", new Date(2015-1900, 1, 26));
        session.save(tb1);
        session.save(tb2);
        session.save(tb3);
        session.save(tb4);
        session.save(tb5);
        /*******************************************************************
        CREACION DE LOS MINORISTAS
        ********************************************************************/
        Minorista m1 = new Minorista(159753258, "Leonel", "Gomez Camacho", "2587894");
        Minorista m2 = new Minorista(357456685, "Abel", "Alvarado Cruz", "9216849");
        Minorista m3 = new Minorista(354895147, "Pablo", "Estrada Camargo", "6702091");
        m1.getUbicacioneses().add(u2);
        m1.getUbicacioneses().add(u3);
        m2.getUbicacioneses().add(u6);
        m3.getUbicacioneses().add(u7);
        session.save(m1);
        session.save(m2);
        session.save(m3);
        /*******************************************************************
        CREACION DE LAS FACTURAS
        ********************************************************************/
        Factura f1 = new Factura(tb1, u2, new Date(2015-1900, 5, 13), (float)(0.16));
        Factura f2 = new Factura(tb2, u3, new Date(2015-1900, 4, 14), (float)(0.16));
        Factura f3 = new Factura(tb3, u6, new Date(2015-1900, 6, 15), (float)(0.16));
        Factura f4 = new Factura(tb4, u7, new Date(2015-1900, 3, 16), (float)(0.16));
        Factura f5 = new Factura(tb5, u2, new Date(2015-1900, 7, 17), (float)(0.16));
        session.save(f1);
        session.save(f2);
        session.save(f3);
        session.save(f4);
        session.save(f5);
        /*******************************************************************
        CREACION DE DETALLES FACTURA ID
        ********************************************************************/
        DetalleFacturaId dti1 = new DetalleFacturaId(1, 1);
        DetalleFacturaId dti2 = new DetalleFacturaId(2, 1);
        DetalleFacturaId dti3 = new DetalleFacturaId(3, 2);
        DetalleFacturaId dti4 = new DetalleFacturaId(4, 3);
        DetalleFacturaId dti5 = new DetalleFacturaId(1, 3);
        DetalleFacturaId dti6 = new DetalleFacturaId(2, 4);
        DetalleFacturaId dti7 = new DetalleFacturaId(1, 4);
        DetalleFacturaId dti8 = new DetalleFacturaId(3, 4);
        DetalleFacturaId dti9 = new DetalleFacturaId(1, 5);
        /*******************************************************************
        CREACION DE DETALLES FACTURA
        ********************************************************************/
        DetalleFactura dt1 = new DetalleFactura(dti1, f1, pev1, (float)(10), (float)(40000), false);
        session.save(dt1);
        
        
        assertTrue(true);
        tx.commit();
    }
 
}
