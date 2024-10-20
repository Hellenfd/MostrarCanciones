<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Canciones</title>
    </head>
    <body>
        <h2>Lista de Canciones</h2>
        <table border="1">
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Detalle</th>
            </tr>
            <c:forEach var="cancion" items="${listaCanciones}">
                <tr>
                    <td>${cancion.titulo}</td>
                    <td>${cancion.artista}</td>
                    <td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
