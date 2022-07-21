<%-- 
    Document   : Show
    Created on : 14-Jul-2022, 12:05:09
    Author     : ADMIN
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3><h3/>
        <table border='1'>
            <tr>
                <td>FirstName</td>
                <td>LastName</td>
                <td>Days</td>
            </tr>
            <c:forEach items="${list}" var="o">
                <tr>
                <td>${o.firstname}</td>
                <td>${o.lastname}</td>
                <td>${o.days}</td>
               </tr>
            </c:forEach>
        </table>
    </body>
</html>
