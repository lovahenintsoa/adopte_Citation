package service.business.jeu.citation;




import dao.jeu.citation.DaoCitation;
import metier.jeu.citation.Theme;
import metier.jeu.citation.Themes;
import service.exception.UserException;

public class ServiceCitation {
	
	private DaoCitation daoCitation;
	
	public ServiceCitation() {
		daoCitation = new DaoCitation();
	}

	public void creerTheme(Theme theme) throws UserException {
		System.out.println("ServiceCitation - creerTheme " + theme);
		
		// control id numerique, non negatif
		// libelle !null, taille, blanc non significatif
		
		// appel dao pour creer theme
		
		daoCitation.creer(theme);

	}
	
	public Themes getThemes() {
		Themes themes= null;
		themes =daoCitation.getThemes();
		return themes;
	}

	
	public void doSuppression(int idTheme) throws UserException {
		System.out.println("vous etes ici service citaion " + idTheme);
		daoCitation.doSuppression(idTheme);
		
	}
	
}
