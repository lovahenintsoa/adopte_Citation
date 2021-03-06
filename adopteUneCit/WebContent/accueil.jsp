<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Adopte Une Cit'</title>

	<link rel="shortcut icon" href="<%=request.getContextPath() %>/assets/images/gt_favicon.png">
	
	<!-- Bootstrap itself -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" type="text/css">

	<!-- Custom styles -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/magister.css">

	<!-- Fonts -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href='http://fonts.googleapis.com/css?family=Wire+One' rel='stylesheet' type='text/css'>
</head>

<!-- use "theme-invert" class on bright backgrounds, also try "text-shadows" class -->
<body class="theme-invert">
<jsp:include page="/WEB-INF/nav/menu.jsp"></jsp:include>


<!-- Main (Home) section -->
<section class="section" id="head">
	<div class="container">

		<div class="row">
			<div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">	

				<!-- Site Title, your name, HELLO msg, etc. -->
				<h1 class="title">adopteUneCit'</h1>
				<h2 class="subtitle">Eclate toi tous les matins !</h2>

				<h3 class="tagline">
					On est pas des amateurs ... non mais quoi hein !!!  
				</h3>
				
				
				<p><a href="https://drive.google.com/" class="btn btn-default btn-lg">Vers le drive</a></p>
	
			</div> <!-- /col -->
		</div> <!-- /row -->
	
	<form method ="post" action ="#">
  <div class="form-group">
    <label for="exampleInputEmail1">Pseudo</label>
    <input class="form-control" id="pseudo" aria-describedby="emailHelp" placeholder="Entrer pseudo" name="pseudoCo" style = "width:200px ;">
    
  </div>
  <div id="cadreMessage">
             		<jsp:useBean id="message"      class="java.lang.String"    scope="request" />
             		<% if (message != null) { %><label><%= message %></label> <% } %> 	    
             		          	
             	</div>
             	  <div id="cadreMessage1">
             	<jsp:useBean id="message1"      class="java.lang.String"    scope="request" />
             		<% if (message != null) { %><label><%= message1 %></label> <% } %> 	
             		</div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="mdpCo"  style = "width:200px ;">
  </div>

  <button type="submit" class="btn btn-primary" formAction ="<%=request.getContextPath() %>/site/connexion">Se connecter</button>
  <button type="submit" class="btn btn-primary" formAction ="<%=request.getContextPath() %>/site/deconnexion">deconnetion</button>
</form>
	</div>
</section>

<!-- Load js libs only when the page is loaded. -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/modernizr.custom.72241.js"></script>
</body>
</html>