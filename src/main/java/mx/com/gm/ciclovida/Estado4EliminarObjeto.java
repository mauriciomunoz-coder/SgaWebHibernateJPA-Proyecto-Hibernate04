package mx.com.gm.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjeto {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        
        //definimos un objeto
        Contacto contacto = new Contacto();
        
        //1. transitivo
        contacto = em.find(Contacto.class, 3);
        
        em.getTransaction().begin();
        
        //2. persistence
        em.remove(em.merge(contacto));
        
        em.getTransaction().commit();
        
        
        //3. transitivo
        System.out.println("");
        
        
    }
}
