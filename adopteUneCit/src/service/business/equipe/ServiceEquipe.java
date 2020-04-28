package service.business.equipe;

import dao.equipe.DaoEquipe;
import metier.equipe.Developpeur;
import metier.equipe.Developpeurs;
import metier.equipe.Formation;
import service.exception.UserException;

public class ServiceEquipe {
	private DaoEquipe daoEquipe;
	
	public ServiceEquipe() {
		daoEquipe=new DaoEquipe();
	}

	public Developpeurs getDevPasseTriePrenom(Formation formation) throws UserException {
		Developpeurs developpeursPasses = daoEquipe.getDevPasseTriePrenom(formation);
		return developpeursPasses;
	}

	public Developpeurs getDevNonPasseTriePrenom(Formation formation) {
		Developpeurs developpeursNonPasses = daoEquipe.getDevNonPasseTriePrenom( formation);
		return developpeursNonPasses;
	}
	
	public boolean isConnexionDeveloppeurOK(String pseudo, String pw) {
		//System.out.println("service ici");
		return daoEquipe.isConnexionDeveloppeurOK(pseudo, pw);
	}

	public Developpeur getDeveloppeurByPseudo(String pseudo) throws UserException {
		System.out.println( daoEquipe.getDeveloppeurByPseudo( pseudo));
		return daoEquipe.getDeveloppeurByPseudo( pseudo);
	}
}

