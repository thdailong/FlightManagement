<%-- 
    Document   : Loginfile
    Created on : 14-Jul-2022, 11:25:30
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login form</h1>
        <form action="LoginControl" method="post">
            username: <input type="text" name="username"/><br>
            password: <input type="text" name="password"/><br>
            <input type="submit" value="login"/>
        </form>
    </body>
</html>
