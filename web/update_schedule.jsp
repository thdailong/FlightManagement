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
        <h1>Update Schedule</h1>
        <form action="UpdateSchedulefinal" method="GET">
            ID: <input value="${sc.getID()}" name="ID" type="text" readonly><br><br>
            From Airport: <input value="${sc.getFromAirport()}" name="from_airport" type="text" required><br><br>
<!--            <select name="from_airport">
                <c:forEach items="${listA}" var="a">
                    <option value="${a.getID()}">
                        ${a.getName()}
                    </option>
                </c:forEach>
            </select><br><br>-->
                      
            To Airport: <input value="${sc.getToAirport()}" name="to_airport" type="text" required><br><br>
            Start time: <input value="${sc.getTimeFrom()}" name="start_time" type="time" required><br><br>
            End time: <input value="${sc.getTimeTo()}" name="end_time" type="time" required><br><br>

            <input type="submit" value="Update">
            <a href="ControlSchedule"><input type="button" value="Return"></a>
        </form>
    </body>
</html>
