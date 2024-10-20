<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción</title>
</head>
<body>
    <h2>Agregar Nueva Canción</h2>
    <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
        <div>
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" type="text" />
            <form:errors path="titulo" />
        </div>
        <div>
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista" type="text" />
            <form:errors path="artista" />
        </div>
        <div>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" type="text" />
            <form:errors path="album" />
        </div>
        <div>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" type="text" />
            <form:errors path="genero" />
        </div>
        <div>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" type="text" />
            <form:errors path="idioma" />
        </div>
        <button type="submit">Agregar Canción</button>
    </form:form>
    <br/>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
