<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition d'un lieu d'accueil</title>
</head>
<body>
  <form action="/Devoir_PWA/PlaceUpdater" method="post">
      <h3>id: ${place.id}</h3>
      Name: <input type="text" name="name" value="${place.name}">
      Type: <input type="text" name="type" value="${place.type}">
      Phonenumber: <input type="text" name="phonenumber" value="${place.phonenumber}">
      Mail: <input type="text" name="mail" value="${place.mail}">
      InfosPMR: <input type="text" name="infosPMR" value="${place.infosPMR}">
      Commentary: <input type="text" name="commentary" value="${place.commentary}">
      Capacity: <input type="text" name="capacity" value="${place.capacity}">
      <input type="hidden" value="${place.id}" name="placeID">
      <input type="submit" value="Submit changes">
  </form>
</body>
</html>