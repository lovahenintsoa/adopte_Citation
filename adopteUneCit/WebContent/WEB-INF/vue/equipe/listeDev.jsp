<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metier.equipe.Developpeur" %>
<%@ page import="metier.equipe.Developpeurs" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
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
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/magister.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/listeDev.css">

	<!-- Fonts -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href='http://fonts.googleapis.com/css?family=Wire+One' rel='stylesheet' type='text/css'>
	
	
	

</head>

<!-- use "theme-invert" class on bright backgrounds, also try "text-shadows" class -->
<body class="theme-invert">
<jsp:include page="/WEB-INF/nav/menu.jsp"></jsp:include>

<!-- Fourth (Contact) section -->
<section class="section" id="head">
	<div class="container"> <!-- container -->
	
		<h2 class="text-center title">Liste dev</h2>

		<div class="row">	<!-- debut row -->
		
		
		
<!-- div gauche -->	<div class="col-sm-6 col-sm-offset-2 text-center">
						<section id="team1" class="pb-2">
    						<div class="container">
        						<h2 class="section-title h2">Passés</h2>
        					</div>
       	<!-- bloc -->		<div class="row">
       	<jsp:useBean id="developpeursPasses"    class="metier.equipe.Developpeurs"    scope="request" />
       	
							 <%
			 for(Developpeur developpeur: developpeursPasses){
					%>	
								
								
								<!-- Team member passe -->
					            <div class="col-xs-12 col-sm-6 col-md-4">
					                <div class="image-flip" >
					                    <div class="mainflip">
					                        <div class="frontside">
					                            <div class="card">
					                                <div class="card-body text-center">
					                                    <p><img class="img-fluid" src="<%=request.getContextPath() %>/assets/imgdev/<%=developpeur.getImagePortrait() %>" alt="card image"></p>
					                                    <h6 style="font-size:12px" class="card-title" ><%=developpeur.getPrenom() %><br><%=developpeur.getPseudo() %></h6>
					                                    <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
					                                </div>
					                            </div>
					                        </div>
					                        <div class="backside">
					                            <div class="card">
					                                <div class="card-body text-center mt-4">
					                                    <h4 class="card-title"><%=developpeur.getPrenom() %></h4>
					                                    <p class="card-text"><%=developpeur.getNom() %></p>
					                                </div>
					                            </div>
					                        </div>
					                    </div>
					                </div>
					            </div>
					            <!-- ./Team member -->
					            
					    <% } %>        
					            
					            
   		<!-- fin bloc -->	</div>
        				</section>
<!-- fin gauche -->	</div>
<!-- div droite -->	<div class="col-sm-6 col-sm-offset-2 text-center">
						<section id="team2" class="pb-2">
    						<div class="container">
        						<h2 class="section-title h2">Non passés</h2>
        					</div>
	<!-- bloc -->			<div class="row">

								<!-- Team member -->
					            <div class="col-xs-12 col-sm-6 col-md-4">
					                <div class="image-flip" >
					                    <div class="mainflip">
					                        <div class="frontside">
					                            <div class="card">
					                                <div class="card-body text-center">
					                                	<p><img class="img-fluid" src="<%=request.getContextPath() %>/assets/imgdev/default.png" alt="card image"></p>

					                                    <h6 style="font-size:12px" class="card-title" >Pierre<br>Pseudo</h6>
					                                    <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
					                                </div>
					                            </div>
					                        </div>
					                        <div class="backside">
					                            <div class="card">
					                                <div class="card-body text-center mt-4">
					                                    <h4 class="card-title">Pierre</h4>
					                                    <p class="card-text">Truc</p>
					                                </div>
					                            </div>
					                        </div>
					                    </div>
					                </div>
					            </div>
					            <!-- ./Team member -->
 	
	<!-- fin bloc -->		</div>        					
        				</section>
<!-- fin droite -->	</div>
			
			
			
			
		</div><!-- fin row -->
			
			

	</div> <!-- Fin container -->
</section>




<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/modernizr.custom.72241.js"></script>
</body>
</html>