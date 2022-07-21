<%-- 
    Document   : ExportTicket
    Created on : 15-07-2022, 13:07:59
    Author     : Thanh Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            *{
                box-sizing: border-box;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
            }
            body{
                font-family: Helvetica;
                -webkit-font-smoothing: antialiased;
                background: rgba( 71, 147, 227, 1);
            }
            h2{
                text-align: center;
                font-size: 18px;
                text-transform: uppercase;
                letter-spacing: 1px;
                color: white;
                padding: 30px 0;
            }

            /* Table Styles */

            .table-wrapper{
                margin: 10px 70px 70px;
                box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
            }

            .fl-table {
                border-radius: 5px;
                font-size: 12px;
                font-weight: normal;
                border: none;
                border-collapse: collapse;
                width: 100%;
                max-width: 100%;
                white-space: nowrap;
                background-color: white;
            }

            .fl-table td, .fl-table th {
                text-align: center;
                padding: 8px;
            }

            .fl-table td {
                border-right: 1px solid #f8f8f8;
                font-size: 12px;
            }

            .fl-table thead th {
                color: #ffffff;
                background: #4FC3A1;
            }


            .fl-table thead th:nth-child(odd) {
                color: #ffffff;
                background: #324960;
            }

            .fl-table tr:nth-child(even) {
                background: #F8F8F8;
            }

            /* Responsive */

            @media (max-width: 767px) {
                .fl-table {
                    display: block;
                    width: 100%;
                }
                .table-wrapper:before{
                    content: "Scroll horizontally >";
                    display: block;
                    text-align: right;
                    font-size: 11px;
                    color: white;
                    padding: 0 0 10px;
                }
                .fl-table thead, .fl-table tbody, .fl-table thead th {
                    display: block;
                }
                .fl-table thead th:last-child{
                    border-bottom: none;
                }
                .fl-table thead {
                    float: left;
                }
                .fl-table tbody {
                    width: auto;
                    position: relative;
                    overflow-x: auto;
                }
                .fl-table td, .fl-table th {
                    padding: 20px .625em .625em .625em;
                    height: 60px;
                    vertical-align: middle;
                    box-sizing: border-box;
                    overflow-x: hidden;
                    overflow-y: auto;
                    width: 120px;
                    font-size: 13px;
                    text-overflow: ellipsis;
                }
                .fl-table thead th {
                    text-align: left;
                    border-bottom: 1px solid #f7f7f9;
                }
                .fl-table tbody tr {
                    display: table-cell;
                }
                .fl-table tbody tr:nth-child(odd) {
                    background: none;
                }
                .fl-table tr:nth-child(even) {
                    background: transparent;
                }
                .fl-table tr td:nth-child(odd) {
                    background: #F8F8F8;
                    border-right: 1px solid #E6E4E4;
                }
                .fl-table tr td:nth-child(even) {
                    border-right: 1px solid #E6E4E4;
                }
                .fl-table tbody td {
                    display: block;
                    text-align: center;
                }
            }

            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
            .myLink {display: none}
        </style>
    </head>
    <body class="w3-light-grey">
        <form action="export">
            Input ID: <input type="text" name="id"><br>
            <input type="submit" value="Search">
        </form>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead class="thead-dark">
                    <tr>
                        <th><h1>ID</h1></th>
                        <th><h1>IDFlight</h1></th>
                        <th><h1>FirstName</h1></th>
                        <th><h1>LastName</h1></th>
                        <th><h1>CCCD</h1></th>
                        <th><h1>IDListTicket</h1></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.result}" var="c">
                        <tr>
                            <td>${c.getId()}</td>
                            <td>${c.getIdFlight()}</td>
                            <td>${c.getFirstName()}</td>
                            <td>${c.getLastName()}</td>
                            <td>${c.getCccd()}</td>
                            <td>${c.getIdListTicket()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
