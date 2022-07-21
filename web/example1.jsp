<%-- 
    Document   : searchFlight
    Created on : Jul 13, 2022, 2:26:44 PM
    Author     : thdai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <title>W3.CSS Template</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
            .myLink {display: none}
        </style>
    </head>
    <body class="w3-light-grey">

        <!-- Navigation Bar -->
        <div class="w3-container">
            <div class="w3-bar w3-white w3-border-bottom w3-xlarge">
                <a href="index.jsp" class="w3-bar-item w3-button w3-text-red w3-hover-red"><b><i class="fa fa-home w3-margin-right"></i>FLIGHTMANAGEMENT</b></a>
                <div class="w3-dropdown-hover">
                    <button class="w3-button">Manager</button>
                    <div class="w3-dropdown-content w3-bar-block w3-card-4">
                        <a href="Loginfile.jsp" class="w3-bar-item w3-button">Search History</a>
                        <a href="#" class="w3-bar-item w3-button"></a>
                    </div>
                </div>
                <div class="w3-dropdown-hover">
                    <button class="w3-button">Admin</button>
                    <div class="w3-dropdown-content w3-bar-block w3-card-4">
                        <a href="#" class="w3-bar-item w3-button">Add airport</a>
                        <a href="#" class="w3-bar-item w3-button">Add schedule</a>
                        <a href="#" class="w3-bar-item w3-button">Search history</a>
                    </div>
                </div>
                <a href="#" class="w3-bar-item w3-button w3-right w3-hover-red w3-text-grey">Sign Up</a>
                <a href="#" class="w3-bar-item w3-button w3-right w3-hover-red w3-text-grey">Login</a>
                <a href="#" class="w3-bar-item w3-button w3-right w3-hover-red w3-text-grey">Profile</a>
            </div>
        </div>

        <!-- Header -->
        <div class="w3-container">

            <h1>đưa nội dung vào đây</h1>
            
        </div>

        <!-- Page content -->


        <!-- Footer -->
        <footer class="w3-container w3-center w3-opacity w3-margin-bottom">
            <h5>Find Us On</h5>
            <div class="w3-xlarge w3-padding-16">
                <i class="fa fa-facebook-official w3-hover-opacity"></i>
                <i class="fa fa-instagram w3-hover-opacity"></i>
                <i class="fa fa-snapchat w3-hover-opacity"></i>
                <i class="fa fa-pinterest-p w3-hover-opacity"></i>
                <i class="fa fa-twitter w3-hover-opacity"></i>
                <i class="fa fa-linkedin w3-hover-opacity"></i>
            </div>
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank" class="w3-hover-text-green">w3.css</a></p>
        </footer>

        

    </body>
</html>

