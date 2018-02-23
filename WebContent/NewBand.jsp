<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <h1>
      Entrez les informations du nouveau groupe
      
    </h1>
    <form action="/Devoir_PWA/AddArtist" method="post">
      Name: <input type="text" name="name">
      
      Members: 
      Country: <input type="text" name="country">
      Genre: <input type="text" name="genre">
      <input type="hidden" value="Band" name="artistType">
      <input type="submit" value="Add new artist">

    </form>

</body>
</html>