<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nearest bike station</title>
</head>
<body>

<%--   ${listBikeStation} --%>
  

  <table>
      <tr>
        <th>
          Name
        </th>
        <th>
          Address
        </th>
        <th>
          Available bike stands
        </th>
      </tr>
      
      <c:forEach items="${listBikeStation}" var="bikeStation">
        <tr>
          <td>
            ${bikeStation.getString('name')}
          </td>  
          <td>
            ${bikeStation.getString('address')}
          </td>  
          <td>
            ${bikeStation.getInt('available_bike_stands')}
          </td>  
        </tr>    
      </c:forEach>

      
    </table>
</body>
</html>