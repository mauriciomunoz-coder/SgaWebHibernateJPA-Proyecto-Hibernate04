package mx.com.gm.dao;

import mx.com.gm.domain.Contacto;

import javax.persistence.Query;
import java.util.List;

public class ContactoDao extends GenericDAO{


    public List<Contacto> listar() {
        String consulta = "SELECT c FROM Contacto c";
        em = getEntityManager(); //nos conecta a la BD
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } /*finally {
            if (em != null) {
                em.close();
            }
        }*/
    }

    public void actualizar(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } /*finally {
            if (em != null) {
                em.close();
            }
        }*/
    }

    public void eliminar(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } /*finally {
            if (em != null) {
                em.close();
            }
        }*/
    }

    public Contacto buscarPorId(Contacto contacto) {
        em = getEntityManager();
        return em.find(Contacto.class, contacto.getIdContacto());

    }
}
