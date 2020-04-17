<%@page import= "java.util.ArrayList" %>
<%@page import= "metier.jeu.citation.Themes" %>
<%@page import= "metier.jeu.citation.Theme" %>

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
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/magister.css">
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
				<h1 class="title">Les Themes</h1>
				<h2 class="subtitle">Plus c'est fou, plus on rit :)</h2>

				<!-- Le formulaire -->
				<form method="post" action="<%=request.getContextPath() %>/citation/creerTheme">
	               <fieldset>
	                 <div   class="col-md-3 col-lg-3"></div>     
	                 <div   class="col-md-6 col-lg-6">    
		                 <div class="form-group">
		                   <label for="id">R&eacute;f&eacute;rence</label>
		                   <input type="number" class="form-control" id="id" name="ajout_id">
		                 </div>
		                 
		                 <div class="form-group">
		                   <label for="libelle">Libell&eacute;</label>
		                   <input type="text" class="form-control" id="libelle" name="ajout_theme" placeholder="Plus c'est fou, plus on rit :)">
		                 </div>
		                 
		                 <button class="btn btn-primary" id="enreg_theme" type="submit">Enregistrer</button>

	   				 </div>
	               </fieldset>
             	</form>
             	
             	<div id="cadreMessage">
             		<jsp:useBean id="message"      class="java.lang.String"    scope="request" />
             		<% if (message != null) { %><label><%= message %></label> <% } %> 	              	
             	</div>
                    	
             	<!-- Debut Liste des themes -->
	     		<div class="card">
			        <div class="card-header" role="tab" id="headingOne">
			          <h5 class="mb-0">
			            <a id="affiche_theme" class="collapsed btn btn-primary" data-toggle="collapse" 
			                                  href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
			                                  Liste des th&egrave;mes
			            </a>
			          </h5>
			        </div>
			        <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne">
			          <div class="card-body">
			          
			            <!-- DM debut liste 
				            table-sm	: petite hauteur de ligne
				            table-dark  : theme noir
				            table-striped : 1 ligne de la couleur de base (noir), 1 ligne un peu plus clair
			            -->
			            <form method="post" action="<%=request.getContextPath() %>/citation/suppressionTheme">
						<table class="table table-sm table-hover table-striped .table-responsive">
						<thead class="thead-dark">
							<tr><th></th><th>#</th><th>Themes</th></tr>
						</thead>
						<tbody>
							  
    			
    	
		<jsp:useBean id="themes"      class="metier.jeu.citation.Themes"    scope="request" />
				
			  <%
			 for(Theme themi: themes){
					%>
						<tr>
							<td><input name="choix_theme" type="radio" value=<%=themi.getId() %>></td>
							<td><%=themi.getId()%></td>
							<td><%=themi.getLibelle()%></td>
							
						</tr>
					
					<%}
			%>
						</tbody>
						</table>
						 <button class="btn btn-primary" id="suppr_theme" formAction="<%=request.getContextPath() %>/citation/suppressionTheme" type="submit">Supprimer</button>
		                 <button class="btn btn-primary" id="modif_theme" type="submit">Modifier</button>
						</form>
			 			<!-- DM fin liste -->   
			 			       
			          </div>	<!-- fin card-body -->
			        </div>	<!--  fin collapseTwo -->
		      	</div>	<!-- fin card -->
	
	
				<!-- fin liste theme -->
				
				
			</div> <!-- /col -->
		</div> <!-- /row -->
	
	</div>
	
</section>

<!-- Load js libs only when the page is loaded. -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/modernizr.custom.72241.js"></script>
</body>
</html>