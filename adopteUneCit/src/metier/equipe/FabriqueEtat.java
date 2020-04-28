package metier.equipe;

public class FabriqueEtat {

	
	public static Etat getEtat(int idEtat) {
		Etat etat= null;
		switch (idEtat) {
		case 1: 
			etat=new NonPasse();
			break;
		
		case 2:
			etat=new Futur();
			break;
		case 3:
			
			etat=new Ancien();
			break;
		
		
		
		}
		return etat;
		
	}
	
	public static Etat getEtat(EtatDeveloppeur etatDeveloppeur) {
		Etat etat = null;
		if 		(etatDeveloppeur == EtatDeveloppeur.ANCIEN) 	etat = new Ancien();
		else if (etatDeveloppeur == EtatDeveloppeur.FUTUR) 		etat = new Futur();
		else if (etatDeveloppeur == EtatDeveloppeur.NON_PASSE) 	etat = new NonPasse();
		return etat;
	}
	public static Etat getEtatFutur() {
		
		return new Futur();
	}

	public static Etat getEtatAncien() {
		
		return new Ancien();
	}
	
	public static Etat getEtatNonPasse() {
		
		return new NonPasse();
	}
}	
	