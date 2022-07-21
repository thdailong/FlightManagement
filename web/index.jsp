<%-- 
    Document   : index
    Created on : Jul 19, 2022, 3:39:21 PM
    Author     : Admin
--%>

<%@page import="Data.GetData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    GetData data = new GetData();
    String dataList = data.DataListAirport(0);
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
            <header class="bg-dark py-5">
                <div class="container px-5">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-6">
                            <div class="text-center my-5">
                                <h1 class="display-5 fw-bolder text-white mb-2">Travel around the world with us</h1>
                                <p class="lead text-white-50 mb-4">Make your vacation stop wasting time by booking flight</p>
                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
                                    <a class="btn btn-primary btn-lg px-4 me-sm-3" href="#bookFlight">Book flight</a>
                                    <a class="btn btn-outline-light btn-lg px-4" href="#!">Manage booking</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- Features section-->



            <form class="container py-5" action="ChooseFlight" method="GET" id="bookFlight">
                <div class="card">
                    <div class="card-header">
                        Booking flight
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <label>Departure</label>
                                <select name="from" class="form-control" required>
                                    <option value="">Choose your departure</option>
                                <%=dataList%>
                            </select>
                        </div>
                        <div class="col">
                            <label>Arrival</label>
                            <select name="to" class="form-control" required>
                                <option value="">Choose your arrival</option>
                                <%=dataList%>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label>Day</label>
                            <input type="date" class="form-control" placeholder="Day" name="date" required>
                        </div>
                        <div class="col">
                            <label>Seat</label>
                            <input type="number" min="1" max="6" name="seat" class="form-control" required>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary" style="margin-top:10px">Find</button>
                </div>
            </div>

        </form>

        <!-- Pricing section-->
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
