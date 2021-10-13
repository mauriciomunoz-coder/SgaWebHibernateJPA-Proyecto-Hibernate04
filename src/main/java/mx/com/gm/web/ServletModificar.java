package mx.com.gm.web;

import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.servicio.ServicioAlumno;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.encontrarById(alumno);

        //request.setAttribute("alumno", alumno);
        HttpSession sesion = request.getSession(); //maneja el objeto en una sesion
        sesion.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String noCalle = request.getParameter("noCalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");


        HttpSession sesion = request.getSession();
        Alumno alumno = (Alumno) sesion.getAttribute("alumno");  //recupera el alumno que se compartio en la sesion


        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.getDomicilio().setCalle(calle);
        alumno.getDomicilio().setNoCalle(noCalle);
        alumno.getDomicilio().setPais(pais);
        alumno.getContacto().setEmail(email);
        alumno.getContacto().setTelefono(telefono);


        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);

        sesion.removeAttribute("alumno"); //elimina el objeto de la sesion

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
