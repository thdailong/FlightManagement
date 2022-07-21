<%-- 
    Document   : addairport
    Created on : Jul 15, 2022, 2:01:43 PM
    Author     : phuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add AirPort</h1>
        <form action="AddAirport" method="GET">
            Name: <input name="name" type="text" required><br><br>
            <input type="submit" value="Add">
            <a href=""><input type="button" value="Return"></a>
        </form>
    </body>
</html>
