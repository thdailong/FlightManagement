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
                <th>From Airport</th>
                <th>To Airport</th>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
            <c:forEach items="${listS}" var="a">
                <tr>
                    <td>${a.getID()}</td>
                    <td>${a.getFromAirport()}</td>
                    <td>${a.getToAirport()}</td>
                    <td>${a.getTimeFrom()}</td>
                    <td>${a.getTimeTo()}</td>
                    <td><a href="DeleteSchedule?sid=${a.getID()}">delete</a> <a href="UpdateSchedule?sid=${a.getID()}">Edit</a></td>
                    
                </tr>
            </c:forEach>
        </table>
        <a href="add_schedule.jsp"><input type="submit" value="Add Schedule"></a>
        <a href="ControlAirport"><input type="submit" value="List Airport"></a>
    </body>
</html>
