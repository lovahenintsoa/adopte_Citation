package service.web;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter (urlPatterns = {"/*"})
public class UrlFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest  requestHttp  = (HttpServletRequest)  request;
		HttpServletResponse responseHttp = (HttpServletResponse) response;
		
		String chemin  		= requestHttp.getServletPath() + "/";
		
		/*
		 *   /				//	intercept et affiche la page d'accueil
		 *   /equipe*			laisse passer (ControlEquipe   /equipe/*)
		 *   /citation*			laisse passer (ControlCitation)
		 *   les autres 		intercept et affiche 404.jsp
		 */
		
		if (chemin.equals("//") ) {
			request.getRequestDispatcher("/accueil.jsp").forward(request,response);		
		//	RequestDispatcher disp = requestHttp.getRequestDispatcher("/accueil.jsp");
		//	disp.forward(requestHttp, responseHttp);
			
//			requestHttp.getRequestDispatcher("/accueil.jsp").forward(requestHttp, responseHttp);
		}
//		else if (chemin.startsWith("/equipe") || chemin.startsWith("/citation") || chemin.startsWith("/assets")) {
//			chain.doFilter(requestHttp, responseHttp);
//		}
		else if (chemin.startsWith("/equipe")) {
			chain.doFilter(requestHttp, responseHttp);
		}
		else if (chemin.startsWith("/citation")) {
			chain.doFilter(requestHttp, responseHttp);
		}
		else if (chemin.startsWith("/site")) {
			chain.doFilter(requestHttp, responseHttp);
		}
		else if (chemin.startsWith("/assets")) {
			chain.doFilter(requestHttp, responseHttp);
		}
		else {
			requestHttp.setAttribute("msgErreur", "Vous avez tripatouill&eacute; l'url!!!");
			RequestDispatcher disp = requestHttp.getRequestDispatcher("/404.jsp");
			disp.forward(requestHttp, responseHttp);
		}
		
		
		
		
	}

}
