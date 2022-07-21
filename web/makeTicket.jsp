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
                            <p><%=request.getAttribute("TIMEFROM")%></p>
                        </div>

                        <div class="col">
                            <svg class="bi bi-exclamation-triangle text-success" width="32" height="32" fill="currentColor" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
                            <h5><i class="bi bi-arrow-right bi-5x" ></i></h5>
                        </div>

                        <div class="col">
                            <p>ARRIVAL</p>
                            <b><%=request.getAttribute("TO")%></b>
                            <p><%=request.getAttribute("TIMETO")%></p>
                        </div>
                    </div>
                </div>
                <form action="FinishBooking" method="GET">
                    <input type="text" name="seat" value="<%=request.getParameter("seat")%>" hidden>
                    <input type="text" name="ScheduleID" value="<%=request.getParameter("ScheduleID")%>" hidden>
                    <input type="text" name="date" value="<%=request.getParameter("date")%>" hidden>
                    <%
                        int seat = Integer.parseInt(request.getParameter("seat"));
                        for (int i = 1; i <= seat; ++i) {
                    %>

                    <div class="row">
                        <div class="col"></div>
                        <div class="col">
                            <div class="card border-primary mb-3" style="max-width: 35rem;">
                                <div class="card-header">Adult <%=i%></div>
                                <div class="card-body text-primary">
                                    <table>
                                        <tr>
                                            <td>First Name: </td>
                                            <td><input type="text" name="FirstName" required></td>
                                        </tr>
                                        <tr>
                                            <td>Last Name: </td>
                                            <td><input type="text" name="LastName" requied></td>
                                        </tr>
                                        <tr>
                                            <td>Date of birth: </td>
                                            <td><input type="date" name="DOB" requied></td>
                                        </tr>
                                        <tr>
                                            <td>CCCD: </td>
                                            <td><input type="text" name="CCCD" requied></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>

                        </div>
                        <div class="col"></div>
                    </div>
                    <%
                        }
                    %>
                    <div class="row">
                        <div class="col"></div>
                        <div class="col">
                            <button type="submit" class="btn btn-primary" style="margin-top:10px">Book</button>
                        </div>
                        <div class="col"></div>
                    </div>

                </form>




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
