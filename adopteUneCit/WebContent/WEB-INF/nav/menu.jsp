<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="mainmenu">
	<div class="container">
		<div class="dropdown">
			<button type="button" class="navbar-toggle" data-toggle="dropdown"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			<!-- <a data-toggle="dropdown" href="#">Dropdown trigger</a> -->
			<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
				<li><a href="<%=request.getContextPath() %>/" class="active">Accueil</a></li>
				<li><a href="<%=request.getContextPath() %>/citation/jeu">Ta citation</a></li>
				<li><a href="<%=request.getContextPath() %>/citation/liste">Les citations</a></li>
				<li><a href="<%=request.getContextPath() %>/equipe/liste">L'&eacute;quipe</a></li>
				<li><a href="<%=request.getContextPath() %>/citation/themes">Les th&egrave;mes</a></li>
			</ul>
		</div>
	</div>
</nav>