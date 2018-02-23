<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter lieu d'accueil</title>
</head>
<body>
  <h1>
      Entrez les informations du nouveau lieu d'accueil
      
    </h1>
  <form action="/Devoir_PWA/AddPlace" method="post">
      <h3>id: ${place.id}</h3>
      Name: <input type="text" name="name">
      Type: <input type="text" name="type">
      Phonenumber: <input type="text" name="phonenumber">
      Mail: <input type="text" name="mail">
      InfosPMR: <input type="text" name="infosPMR">
      Commentary: <input type="text" name="commentary">
      Capacity: <input type="text" name="capacity">
      <input type="submit" value="Submit changes">
  </form>

</body>
</html>