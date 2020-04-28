package service.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import metier.equipe.Developpeur;
import util.message.MessageAppli;

/**
 * Servlet Filter implementation class LoginFilter
 */
// internaute on verifie si l'utilisateur est conecte

@WebFilter (urlPatterns = {"/citation/*","/equipe/*"})
public class LoginFilter implements Filter {

 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
	
	// recuperer le dev en session
		HttpServletRequest  requestHttp  = (HttpServletRequest)  request;
		HttpSession session=  requestHttp.getSession();
		Developpeur developpeur =(Developpeur)session.getAttribute("devConecte");
		// verifier qu'un dev est en session
		System.out.println(" dev " + developpeur);
		
		if (developpeur==null) {
			
			String message = MessageAppli.DEV_PAS_CO;
			System.out.println("farany "+ message);
			requestHttp.setAttribute("message1", message);
			// verifier si le dev n'est pas null + 	// message + page d'accueil
			RequestDispatcher disp = requestHttp.getRequestDispatcher("accueil.jsp");
			disp.forward(requestHttp, response);
		}
	
			
		
		else {
			chain.doFilter(request, response);
		}
		// laisse passe
	
	}


}
