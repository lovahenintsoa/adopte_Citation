package service.business.equipe;

import dao.equipe.DaoEquipe;
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

}
