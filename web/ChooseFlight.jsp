<%-- 
    Document   : index
    Created on : Jul 19, 2022, 3:39:21 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Schedule"%>
<%@page import="Data.GetData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Schedule> arrSchedule = (ArrayList<Schedule>) request.getAttribute("ArrSchedule");
    ArrayList<Integer> SeatRemaining = (ArrayList<Integer>) request.getAttribute("SeatRemaining");

    String res = "";
    for (int i = 0; i < arrSchedule.size(); ++i) {
        String active = "Available";
        if (SeatRemaining.get(i) - Integer.parseInt(request.getParameter("seat")) < 0) {
            active = "Out of stoke";
        }

        String form = "";
        if (active.equals("Available")) {
            form = "<form action='makeTicket'>" + "<input hidden type='text' name='ScheduleID' value=" + arrSchedule.get(i).getID() + ">"
                    + "<input hidden type='text' name='date' value='" + request.getParameter("date") + "'>"
                    + "<input hidden type='text' name='seat' value='" + request.getParameter("seat") + "'>"
                    + "<input hidden type='text' name='from' value='" + request.getAttribute("FROM") + "'>"
                    + "<input hidden type='text' name='to' value='" + request.getAttribute("TO") + "'>"
                    + "<button type='submit' class='btn btn-primary' >Choose</button>"
                    + "</form>";
        } else {
            form = "<button type='submit' class='btn btn-primary' disabled>Choose</button>";
        }

        res += "<tr>"
                + "<th scope='row'>" + arrSchedule.get(i).getID() + "</th>"
                + "<td>" + arrSchedule.get(i).getTimeFrom() + "</td>"
                + "<td>" + arrSchedule.get(i).getTimeTo() + "</td>"
                + "<td>" + active + "</td>" + "<td>" + form + "</td>" + "</tr>";

    }
    
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Business Frontpage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Header-->

            <div class="container py-5">
                <div class="card text-center">
                    <div class="card-header">
                        Your choice
                    </div>
                    <div class="card-body">
                        <h5 class="card-title"><%=request.getParameter("seat")%> adults</h5>
                    <div class="row">

                        <div class="col">
                            <p>DEPARTURE</p>
                            <b><%=request.getAttribute("FROM")%></b>
                        </div>

                        <div class="col">
                            <svg class="bi bi-exclamation-triangle text-success" width="32" height="32" fill="currentColor" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                            <h5><i class="bi bi-arrow-right bi-5x" ></i></h5>
                        </div>

                        <div class="col">
                            <p>ARRIVAL</p>
                            <b><%=request.getAttribute("TO")%></b>
                        </div>
                    </div>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Time departure</th>
                            <th scope="col">Time arrival</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%=res%>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
