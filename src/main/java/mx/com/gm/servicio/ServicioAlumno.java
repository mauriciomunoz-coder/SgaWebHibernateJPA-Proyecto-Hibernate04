package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.AlumnoDao;
import mx.com.gm.domain.Alumno;

public class ServicioAlumno {
    
    private AlumnoDao alumnoDao = new AlumnoDao();
    
    public List<Alumno> listarAlumnos() {
        return alumnoDao.listar();
    }
    
    public void guardarAlumno(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {  //si no existe lo agrega a la BD
            alumnoDao.insertar(alumno);
        } else {
            alumnoDao.actualizar(alumno);  //Si ya existe lo modifica
        }
    }
    
    public void eliminarAlumno(Alumno alumno) {
        alumnoDao.eliminar(alumno);
    }
    
    public Alumno encontrarById(Alumno alumno){
        return alumnoDao.buscarPorId(alumno);
    }
}
