<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ajout d'un artiste</title>
  </head>
  <body>
    <h1>
      Entrez les informations du nouvel artiste
      
    </h1>
    <form action="/Devoir_PWA/AddArtist" method="post">
      Name: <input type="text" name="name">
        Firstname: <input type="text" name="firstname">
        Lastname: <input type="text" name="lastname">
        Role: <input type="text" name="role">
        Sex: 
          <input type="radio" name="sex" value="M" id="Sexe_M">
          <label for="Sexe_M">Male</label>
          <input type="radio" name="sex" value="F" id="Sexe_F">
          <label for="Sexe_F">Female</label>            

      Country: <input type="text" name="country">
      Genre: <input type="text" name="genre">
      <input type="hidden" value="PersonArtist" name="artistType">
      <input type="submit" value="Add new artist">

    </form>
  </body>
</html>