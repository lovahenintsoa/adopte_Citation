package service.web.jeu.citation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.jeu.citation.Theme;
import metier.jeu.citation.Themes;
import service.business.jeu.citation.ServiceCitation;
import service.exception.UserException;

/**
 * Servlet implementation class controlCitation
 */
@WebServlet( urlPatterns = {"/citation/*"} )
public class ControlCitation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceCitation serviceCitation;
	
	@Override
	public void init() throws ServletException {
		serviceCitation = new ServiceCitation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String chemin  		= request.getPathInfo();		
		
		// si /liste 	=> afficher citations.jsp
		// si /themes 	=> afficher themes.jsp
		// si /jeu		=> afficher citation.jsp
		
		if      (chemin.equals("/liste")) 			doListe(request, response);
		else if (chemin.equals("/themes")) 			doThemes(request, response);				
		else if (chemin.equals("/jeu")) 			doJeu(request, response);	
		
		else 										doAutres(request, response);
		
	}

	
		
		
		
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String chemin  		= request.getPathInfo();	
		
		
		if (chemin.equals("/creerTheme")) 			 doCreerTheme(request, response);
		else if(chemin.equals("/suppressionTheme"))  doSuppression(request,response);
		else 										 doAutres(request, response);
	}
	
	private void doSuppression(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("vous etes ici suppr");
				String choixTheme = request.getParameter("choix_theme");
				
				try {
				int idTheme = Integer.parseInt(choixTheme);
				serviceCitation.doSuppression(idTheme);
				}
			
			//	System.out.println("vous etes ici suppr" + idTheme);
				
					
				 catch  (UserException e){
					request.setAttribute("message", e.getMessage());
				}
				doThemes(request, response);
	}

	private void doCreerTheme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idTheme = request.getParameter("ajout_id");
		String libelle = request.getParameter("ajout_theme");
		
		// TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! gerer cas id pas numeric
	
			
		
		try {
		//	idTheme = "a";
			int id = Integer.parseInt(idTheme);
			Theme theme = new Theme(id, libelle);
			serviceCitation.creerTheme(theme);
			// on catch UserException
		} 	catch (NumberFormatException e) {
			request.setAttribute("message","inserer des nombres");
		}
		catch (UserException e) {
			request.setAttribute("message", e.getMessage());
		}
		
		// redirection forward
		doThemes(request, response);
	//	request.getRequestDispatcher("/themescitations").forward(request,response);		
		
	}

	private void doAutres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/404.jsp").forward(request,response);		
	}

	private void doJeu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vue/jeu/citation/citation.jsp").forward(request,response);		
	}

	private void doThemes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Themes themes = serviceCitation.getThemes();
		
		request.setAttribute("themes",themes );
		
		request.getRequestDispatcher("/themescitations").forward(request,response);	
	}
		
	private void doListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/vue/jeu/citation/citations.jsp");
			disp.forward(request,response);	
	}



}
