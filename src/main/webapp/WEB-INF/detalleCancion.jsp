<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Detalle de Canción</title>
    </head>
    <body>
        <h2>Detalle de la Canción</h2>
        <p><strong>Título:</strong> ${cancion.titulo}</p>
        <p><strong>Artista:</strong> ${cancion.artista}</p>
        <p><strong>Álbum:</strong> ${cancion.album}</p>
        <p><strong>Género:</strong> ${cancion.genero}</p>
        <p><strong>Idioma:</strong> ${cancion.idioma}</p>
        <a href="/canciones">Volver a lista de canciones</a>
        <a href="/canciones/formulario/editar/${cancion.id}">Editar Canción</a>
            <form action="/canciones/eliminar/${cancion.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
        <button type="submit">Eliminar Canción</button>
    </form>

    <a href="/canciones">Volver a la lista de canciones</a>
    </body>
</html>
