<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <!DOCTYPE html>
            <html lang="es">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Registro Nuevo Usuario DailyStandApp</title>
            </head>

            <body>
                <div>
                    <H1> Registro de Usuario</H1>
                    <c:if test="${msgError != null}">
                        <c:out value="${msgError}"></c:out>
                    </c:if>
                    <form:form action="/registro/usuario" method="post" modelAttribute="usuario">
                        <form:label path="nombre">Nombre</form:label>
                        <form:input path="nombre" />
                        <br>
                        <form:label path="apellido">Apellido</form:label>
                        <form:input path="apellido" />
                        <br>
                        <form:label path="rut">Rut</form:label>
                        <form:input path="rut" />
                        <br>
                        <form:label path="fechaDeNacimiento">Fecha de Nacimiento</form:label>
                        <form:input type="date" path="fechaDeNacimiento"/>
                        <br>
                        <form:label path="correo">Correo Electrónico</form:label>
                        <form:input type="email" path="correo" />
                        <br>
                        <form:label path="password">Password</form:label>
                        <form:input path="password" />
                        <br>
                        <button type="submit" value="Registrar"> Registrarse </button>
                    </form:form>
                </div>

            </body>

            </html>