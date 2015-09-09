/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.models.Campesino;
import com.mycompany.models.Producto;
import com.mycompany.models.ProductoEnVenta;
import com.mycompany.models.Ubicacion;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import main.PersistenceFacade;
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
 
    /**
     * El objetivo de esta prueba es que el mapeo permita hacer persistentes
     * un nuevo pedido de productos.
     * Estado inicial: base de datos vacía.
     * Prueba: Se almacena un pedido con determinados productos para
     * luego extraer este pedido de la base de datos y verificar que
     * tengan los mismo productos     
     * 
     */
    @Test
    public void registrarPedidoVerificarProductos(){
        Transaction tx=session.beginTransaction();
        Producto p1 = new Producto(1, "Papa Criolla", 60, false);
        session.save(p1);
        Producto p2 = new Producto(2, "Papa Sabanera", 90, false);
        session.save(p2);
        Producto p3 = new Producto(3, "Tomate Chonto", 30, true);
        session.save(p3);
        Ubicacion u1 = new Ubicacion(1, "Calle 123", "Cajica", "Cundinamarca", "20", "70");
        Campesino c1 = new Campesino(1, u1, "Guillermo Leon", "Alvarez Salamanca", "1234567");
        session.save(u1);
        session.save(c1);        
        Set <ProductoEnVenta> s1 = new HashSet<>();
        ProductoEnVenta p1c1 = new ProductoEnVenta(1, c1, p1, "Muy buena calidad de papa criolla",
                    new Date(2015-1900, 2, 5), (float)(60.5), 1000);
        ProductoEnVenta p2c1 = new ProductoEnVenta(2, c1, p2, "Papa sabanera muyyyyyy rica :P",
                    new Date(2015-1900, 9, 7), (float)(20.5), 2000);        
        session.save(p1c1);
        session.save(p2c1);
        s1.add(p1c1);s1.add(p2c1);        
        c1 = (Campesino)session.load(Campesino.class, 1);
        c1.setProductosEnVentas(s1);
        session.update(c1);
        Ubicacion u2 = new Ubicacion(2, "Calle 234", "Chia", "Cundinamarca", "20", "80");
        Campesino c2 = new Campesino(2, u2, "Andres Felipe", "Barrero Chacon", "1234567");
        session.save(u2);session.save(c2);
        Set<ProductoEnVenta> s2 = new HashSet<ProductoEnVenta>();
        ProductoEnVenta p1c2 = new ProductoEnVenta(3, c2, p1, "La mejor papa criolla", 
                new Date(2015-1900, 9, 8), (float)150.6, 1100);
        session.save(p1c2);
        s2.add(p1c2);
        c2 = (Campesino)session.load(Campesino.class, 2);
        c2.setProductosEnVentas(s2);
        session.update(c2);
        Ubicacion u3 = new Ubicacion(3, "Casa de pobre y sin presencia", "Quibdo", "Choco", "40", "-80");
        Campesino c3 = new Campesino(3, u3, "Andres Mauricio", "Melo Torres", "1234567");
        session.save(u3);session.save(c3);
        Set<ProductoEnVenta> s3 = new HashSet<ProductoEnVenta>();
        ProductoEnVenta p1c3 = new ProductoEnVenta(4, c3, p3, "El tomate de Zlatan", 
                new Date(2015-1900, 9, 8), (float)300.50, 2500);
        session.save(p1c3);
        s3.add(p1c3);
        c3 = (Campesino)session.load(Campesino.class, 3);
        c3.setProductosEnVentas(s3);
        session.update(c3);        
        List <Campesino> answer = PersistenceFacade.campesinosPorProducto(session, p1, 20);
        assertTrue("Se esperaba un conjunto con solo un campesino",answer.size()==1);
        for(Campesino c: answer){
            assertTrue("Se esperaba otro campesino",c.equals(c2));
        }
        assertTrue(true);
        tx.commit();        
    }
}
