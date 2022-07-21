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
        User : ${acc.username};
        <br>
        Pass : ${acc.password};
    </body>
</html>
