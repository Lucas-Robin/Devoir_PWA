<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Liste des artistes</title>
  </head>
  <body>
    <h1>
      Bands :
    </h1>
    <table>
      <tr>
        <th>
          ID
        </th>
        <th>
          Name
        </th>
        <th>
          Country
        </th>
        <th>
          Genre
        </th>
        <th>
          Members name
        </th>
        <th>
          Delete
        </th>
        <th>
          Update
        </th>
      </tr>
      <c:forEach items="${lband}" var="a">
        <tr>
          <td>
            ${a.id}
          </td>
          <td>
            ${a.name}
          </td>
          <td>
            ${a.country}
          </td>
          <td>
            ${a.genre}
          </td>
          <td>
            <c:forEach items="${a.members}" var="mem">
              ${mem.name}, 
            </c:forEach>
          </td>
          <td>
            <form action="/Devoir_PWA/DeleteArtist" method="post">
              <input type="hidden" value="${a.id}" name="artistID">
              <input type="submit" value="Delete">
            </form>
          </td>
          <td>
            <form action="/Devoir_PWA/UpdateArtist" method="post">
              <input type="hidden" value="${a.id}" name="artistID">
              <input type="submit" value="Go to update page">
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
    <h1>
      Artists :
    </h1>
    <table>
      <tr>
        <th>
          ID
        </th>
        <th>
          Name
        </th>
        <th>
          Firstname
        </th>
        <th>
          Lastname
        </th>
        <th>
          Role
        </th>
        <th>
          Sex
        </th>
        <th>
          Country
        </th>
        <th>
          Genre
        </th>
        <th>
          Delete
        </th>
        <th>
          Update
        </th>
      </tr>
      <c:forEach items="${lpersonartist}" var="a">
        <tr>
          <td>
            ${a.id}
          </td>
          <td>
            ${a.name}
          </td>
          <td>
            ${a.firstname}
          </td>
          <td>
            ${a.lastname}
          </td>
          <td>
            ${a.role}
          </td>
          <td>
            ${a.sex}
          </td>
          <td>
            ${a.country}
          </td>
          <td>
            ${a.genre}
          </td>
          <td>
            <form action="/Devoir_PWA/DeleteArtist" method="post">
              <input type="hidden" value="${a.id}" name="artistID">
              <input type="submit" value="Delete">
            </form>
          </td>
          <td>
            <form action="/Devoir_PWA/UpdateArtist" method="post">
              <input type="hidden" value="${a.id}" name="artistID">
              <input type="submit" value="Go to update page">
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>  
  </body>
</html>