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
        <h1>Add Schedule</h1>
        <form action="AddSchedule" method="GET">
            From Airport: <input name="from_airport" type="text" required><br><br>
<!--            <select name="from_airport">
                <c:forEach items="${listA}" var="a">
                    <option value="${a.getID()}">
                        ${a.getName()}
                    </option>
                </c:forEach>
            </select><br><br>-->
                      
            To Airport: <input name="to_airport" type="text" required><br><br>
            Start time: <input name="start_time" type="time" required><br><br>
            End time: <input name="end_time" type="time" required><br><br>

            <input type="submit" value="Add">
            <a href="ControlSchedule"><input type="button" value="Return"></a>
        </form>
    </body>
</html>
