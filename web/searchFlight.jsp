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

	</div>
</main>
  </body>
        
</html>
