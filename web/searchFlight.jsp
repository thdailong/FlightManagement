<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Loginfile
    Created on : 14-Jul-2022, 11:25:30
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/searchStyle.css" rel="stylesheet">
    </head>
    <body>
        <main>

            <div class="container">
                <h1>Search your flight</h1>
                <h2>Use your ID</h2>
                <div class="search-box">
                    <div class="search-icon"><i class="fa fa-search search-icon"></i></div>
                    <form action="Search" method="post"class="search-form">
                        <input type="text" name="id"placeholder="Search" id="search" autocomplete="off">
                    </form>



                    <svg class="search-border" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:a="http://ns.adobe.com/AdobeSVGViewerExtensions/3.0/" x="0px" y="0px" viewBox="0 0 671 111" style="enable-background:new 0 0 671 111;"
                         xml:space="preserve">
                    <path class="border" d="M335.5,108.5h-280c-29.3,0-53-23.7-53-53v0c0-29.3,23.7-53,53-53h280"/>
                    <path class="border" d="M335.5,108.5h280c29.3,0,53-23.7,53-53v0c0-29.3-23.7-53-53-53h-280"/>
                    </svg>
                    <div class="go-icon"><i class="fa fa-arrow-right"></i></div>
                </div>
                <div class="row" style="margin-top: 15px;">
                    <c:if test="${list.size()!=0}">
                        <table class="table " >
                            <thead>
                                <tr>
                                    <th>Id</th>

                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Days</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="l" items="${list}">
                                    <tr>
                                        <td>${l.getIDUser()}</td>
                                        <td>${l.getFirstname()}</td>
                                        <td>${l.getLastname()}</td>
                                        <td>${l.getDays()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </c:if>
                </div>
            </div>
        </main>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>

</html>
