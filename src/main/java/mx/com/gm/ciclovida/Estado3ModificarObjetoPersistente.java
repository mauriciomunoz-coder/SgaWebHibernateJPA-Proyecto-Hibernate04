package mx.com.gm.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;


public class Estado3ModificarObjetoPersistente {
     public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Recuperar un Objeto de la base de datos
        Contacto contacto = new Contacto();
        
        //recuperamos el objeto
        //1. estado transitivo
        contacto = em.find(Contacto.class, 3);   // el 3 es el id del objeto

        //2. modificamos el objeto
        contacto.setEmail("claras@mail.com");
        
        
        em.getTransaction().begin();
        
        //2. estado persistente
        em.merge(contacto);
        em.getTransaction().commit();
        
        //3. detached
        System.out.println(contacto);
     }
    
}
