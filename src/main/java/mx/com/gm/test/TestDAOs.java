package mx.com.gm.test;

import java.util.List;
import mx.com.gm.dao.AlumnoDao;
import mx.com.gm.dao.AsignacionDao;
import mx.com.gm.dao.ContactoDao;
import mx.com.gm.dao.CursoDao;
import mx.com.gm.dao.DomicilioDao;

public class TestDAOs {
    public static void main(String[] args) {
        
        AlumnoDao alumnoDao = new AlumnoDao();
        System.out.println("Alumnos: ");
        imprimir(alumnoDao.listar());
        
        
        System.out.println("Domicilios: ");
        DomicilioDao domicilioDao = new DomicilioDao();
        imprimirDomicilio(domicilioDao.listar());
        
        System.out.println("Contactos: ");
        ContactoDao contactoDao = new ContactoDao();
        imprimirContactos(contactoDao.listar());
        
        System.out.println("Cursos: ");
        CursoDao cursoDao = new CursoDao();
        imprimirCursos(cursoDao.listar());
        
        System.out.println("Asignaciones: ");
        AsignacionDao asignacionDao = new AsignacionDao();
        imprimirAsignaciones(asignacionDao.listar());
        
        
    }
    
    private static void imprimir(List coleccion){
        for (Object object : coleccion) {
            //System.out.println("valor: " + object);
        }
    }
    
    
    private static void imprimirDomicilio(List coleccion){
        for (Object dom : coleccion) {
            //System.out.println("valor: " + dom);
        }
    }
    
    private static void imprimirContactos(List coleccion){
        for (Object contacto : coleccion) {
            //System.out.println("valor: " + contacto);
        }
    }
    
    private static void imprimirCursos(List coleccion){
        for (Object curso : coleccion) {
            //System.out.println("valor: " + curso);
        }
    }
    
    private static void imprimirAsignaciones(List coleccion){
        for (Object asignacion : coleccion) {
            System.out.println("valor: " + asignacion);
        }
    }
    
}
