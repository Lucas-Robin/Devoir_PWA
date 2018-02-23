<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des lieux d'accueil</title>
</head>
<body>
    <table>
      <tr>
        <th>
          ID
        </th>
        <th>
          Name
        </th>
        <th>
          Type
        </th>
        <th>
          Phonenumber
        </th>
        <th>
          Mail
        </th>
        <th>
          InfosPMR
        </th>
        <th>
          Commentary
        </th>
        <th>
          Capacity
        </th>
        <th>
          Show list
        </th>
        <th>
          Coordonnées
        </th>
        <th>
          Delete
        </th>
        <th>
          Update
        </th>
      </tr>
      <c:forEach items="${lPlace}" var="place">
        <tr>
          <td>
            ${place.id}
          </td>
          <td>
            ${place.name}
          </td>
          <td>
            ${place.type}
          </td>
          <td>
            ${place.phonenumber}
          </td>
          <td>
            ${place.mail}
          </td>
          <td>
            ${place.infosPMR}
          </td>
          <td>
            ${place.commentary}
          </td>
          <td>
            ${place.capacity}
          </td>
          <td>
            <c:forEach items="${place.showList}" var="show">
              ${show.name}, 
            </c:forEach>
          </td>
          <td>
            lat: ${place.lat}  lon:${place.lon} 
          </td>
          <td>
            <form action="/Devoir_PWA/DeletePlace" method="post">
              <input type="hidden" value="${place.id}" name="placeID">
              <input type="submit" value="Delete">
            </form>
          </td>
          <td>
            <form action="/Devoir_PWA/UpdatePlace" method="post">
              <input type="hidden" value="${place.id}" name="placeID">
              <input type="submit" value="Go to update page">
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
    
    <form action="/Devoir_PWA/NewPlace.jsp" method="post">
      <input type="submit" value="Add new place">
    </form>
  
</body>
</html>