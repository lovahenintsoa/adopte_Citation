package service.web.equipe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.equipe.Developpeurs;
import metier.equipe.Formation;
import service.business.equipe.ServiceEquipe;
import service.exception.UserException;

/**
 * Servlet implementation class ControlEquipe
 */
@WebServlet(  urlPatterns = {"/equipe/*"} )
public class ControlEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceEquipe serviceEquipe  ;
@Override
	public void init() throws ServletException {
		serviceEquipe =new ServiceEquipe();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String chemin  		= request.getPathInfo();		
		
		// si /			=> afficher accueil.jsp
		// si /liste 	=> afficher listeDev.jsp
		
		if      (chemin.equals("/liste")) 		doListe(request, response);
		else if (chemin.equals("/")) 			doAccueil(request, response);				
		else 									doAutres(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/accueil.jsp").forward(request,response);		
	}
	private void doListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuparer la liste des dev passe
		Developpeurs developpeursPasses =null;
		Developpeurs developpeursNonPasses =null;
		try {
			developpeursPasses = serviceEquipe.getDevPasseTriePrenom(getFormation(request));
			System.out.println("liste des dev " + developpeursPasses);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// recuperer la liste futur + non passe
		
		developpeursNonPasses = serviceEquipe.getDevNonPasseTriePrenom(getFormation(request));
		// set attribut
		request.setAttribute("developpeursPasses", developpeursPasses);
		request.setAttribute("developpeursNonPasses", developpeursNonPasses);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/vue/equipe/listeDev.jsp");
		disp.forward(request,response);	
	}
	private void doAutres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/404.jsp").forward(request,response);		
	}
	
	private Formation getFormation(HttpServletRequest request) {
		return new Formation(1,"Developeur web,web mobile");
	}
}
