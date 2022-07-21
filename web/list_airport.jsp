<%-- 
    Document   : ListGroups
    Created on : Jul 1, 2021, 2:23:02 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Of Air Port!</h1>
        <table border="1px solid black">
            <tr>
                <th>ID</th>
                <th>Airport Name</th>
            </tr>
            <c:forEach items="${listA}" var="a">
                <tr>
                    <td>${a.getID()}</td>
                    <td>${a.getName()}</td>
                    <td><a href="DeleteAirport?sid=${a.getID()}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="add_airport.jsp"><input type="submit" value="Add Group"></a>
        <a href="ControlSchedule"><input type="submit" value="List Schedule"></a>
    </body>
</html>
