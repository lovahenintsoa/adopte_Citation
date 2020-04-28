package service.web.site;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.equipe.Developpeur;
import service.business.equipe.ServiceEquipe;
import service.business.jeu.citation.ServiceCitation;
import service.exception.UserException;
import util.message.MessageAppli;

/**
 * Servlet implementation class ControleSite
 */
@WebServlet( urlPatterns = {"/site/*"} )
public class ControleSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceEquipe serviceEquipe;
	
	@Override
	public void init() throws ServletException {
		serviceEquipe = new ServiceEquipe();
	}
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chemin  		= request.getPathInfo();		
		
		// si /liste 	=> afficher citations.jsp
		// si /themes 	=> afficher themes.jsp
		// si /jeu		=> afficher citation.jsp
		
		if(chemin==null) chemin="/";
		if      (chemin.equals("/")) 			doAccueil(request, response);
	
		
		else 									doAutres(request, response);
		
	}

	
	private void doAutres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/404.jsp").forward(request,response);	
		
	}


	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/accueil.jsp").forward(request,response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chemin  		= request.getPathInfo();
		
		if		(chemin==null) chemin="/";
		
		if      (chemin.equals("/")) 			doAccueil(request, response);
		else if(chemin.equals("/connexion"))  doConnexion(request,response);
		
		else 									doAutres(request, response);
	}


	private void doConnexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudoCo");
		String mdp = request.getParameter("mdpCo");
		
		String message = null;
		System.out.println(" connexion" + pseudo + "pass" + mdp);
		
					
		if (pseudo==null || pseudo.isBlank()) message =MessageAppli.RECUP_PSEUDO_PW_KO;
		
		else {
			boolean ok = serviceEquipe.isConnexionDeveloppeurOK(pseudo,mdp);
			
			System.out.println(" arriver" +ok);
			
			if(ok) {
				Developpeur developpeur;
				try {
					message= MessageAppli.RECUP_PSEUDO_PW_OK;
					developpeur = serviceEquipe.getDeveloppeurByPseudo(pseudo);
					
					System.out.println("** ControlSite - doConnexion - developpeur : " + developpeur);
					
					HttpSession session = request.getSession(true);
					session.setAttribute("devConecte", developpeur);
					session.setAttribute("forConnecte", developpeur.getFormation());
				} catch (UserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else message =MessageAppli.RECUP_PSEUDO_PW_KO ;// à changer
		}
		
		
		
		request.setAttribute("message",message );
		
		doAccueil(request, response);
		
	}

}
