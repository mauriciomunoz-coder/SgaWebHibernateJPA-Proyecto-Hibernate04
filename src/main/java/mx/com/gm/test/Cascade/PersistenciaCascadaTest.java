
package mx.com.gm.test.Cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;


public class PersistenciaCascadaTest {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        
        //se crea objeto tipo Domicilio
        Domicilio domicilio = new Domicilio();
        
        domicilio.setCalle("chuntame");
        domicilio.setNoCalle("12 - 89");
        domicilio.setPais("Colombia");
        
        
        //se crea el objeto tipo Contacto
        Contacto contacto = new Contacto();
        
        contacto.setEmail("marianita@mail.com");
        contacto.setTelefono("32578996");
        
        
        //se crea el objeto tipo Alumno
        Alumno alumno = new Alumno();
        
        alumno.setNombre("mariana");
        alumno.setApellido("Muñoz");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

     
        //se crea la transaccion
        em.getTransaction().begin();
        
        //se persiste en la BD
        em.persist(alumno);
        
        //se hace commit para guardar en la BD 
        em.getTransaction().commit();
        
        
        
        System.out.println("Alumno: " + alumno);
        
    }
    
}
