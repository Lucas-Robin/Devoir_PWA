<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edition d'un artiste</title>
  </head>
  <body>
    <form action="/Devoir_PWA/ArtistUpdater" method="post">
      <h3>id: ${artist.id}</h3>
      Name: <input type="text" name="name" value="${artist.name}">
      <c:if test="${isPerson}">
        Firstname: <input type="text" name="firstname" value="${artist.firstname}">
        Lastname: <input type="text" name="lastname" value="${artist.lastname}">
        Role: <input type="text" name="role" value="${artist.role}">
        Sex: 
          <c:if test="${artist.sex == 'M'}">
            <input type="radio" name="sex" value="M" id="Sexe_M" checked>
            <label for="Sexe_M">Male</label>
            <input type="radio" name="sex" value="F" id="Sexe_F">
            <label for="Sexe_F">Female</label>  
          </c:if>
          <c:if test="${artist.sex == 'F'}">
            <input type="radio" name="sex" value="M" id="Sexe_M">
            <label for="Sexe_M">Male</label>
            <input type="radio" name="sex" value="F" id="Sexe_F" checked>
            <label for="Sexe_F">Female</label>  
          </c:if>          
      </c:if>
      <c:if test="${!isPerson}">
        Members: 
      </c:if>
      Country: <input type="text" name="country" value="${artist.country}">
      Genre: <input type="text" name="genre" value="${artist.genre}">
      <input type="hidden" value="${artist.id}" name="artistID">
      <input type="submit" value="Submit changes">

    </form>
  </body>
</html>