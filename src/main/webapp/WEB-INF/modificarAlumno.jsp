<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Agregar Alumno</h1>

<form action="${pageContext.request.contextPath}/ServletModificar" method="post">

    Nombre: <input type="text" name="nombre" value="${alumno.nombre}"/>
    <br/>
    Apellido: <input type="text" name="apellido" value="${alumno.apellido}"/>
    <br/>
    <br/>
    Datos Domicilio:
    <br/>
    Calle: <input type="text" name="calle" value="${alumno.domicilio.calle}"/>
    <br/>
    No. Calle: <input type="text" name="noCalle" value="${alumno.domicilio.noCalle}"/>
    <br/>
    Pais: <input type="text" name="pais" value="${alumno.domicilio.pais}"/>
    <br/>
    <br/>
    Datos de Contacto:
    <br/>
    Email: <input type="email" name="email" value="${alumno.contacto.email}"/>
    <br/>
    Telefono: <input type="tel" name="telefono" value="${alumno.contacto.telefono}"/>
    <br/>
    <input type="submit" name="Modificar" value="Modificar"/>
</form>
</body>
</html>
