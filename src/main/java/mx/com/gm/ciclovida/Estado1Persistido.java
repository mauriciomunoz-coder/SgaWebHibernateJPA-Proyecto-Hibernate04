package mx.com.gm.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;


public class Estado1Persistido {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("lpcmedina@hotmail.com");
        contacto.setTelefono("555555");
        
        //2. estado persistente
        em.getTransaction().begin();
        em.persist(contacto);
        em.getTransaction().commit();
        
        //3. estado detached (separado)
        System.out.println("contacto: " + contacto);
    }
    
}
