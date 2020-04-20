package metier.equipe;

public class FabriqueEtat {

	
	public static Etat getEtat(int idEtat) {
		Etat etat= null;
		switch (idEtat) {
		case 1: 
			etat=new Nonpasse();
			break;
		
		case 2:
			etat=new Future();
			break;
		case 3:
			
			etat=new Ancien();
			break;
		
		
		
		}
		return etat;
		
	}
	
	public static Etat getEtat(EtatDeveloppeur etatdeveloppeur) {
		Etat etat= null;
		
		switch (etatdeveloppeur) {
		case NON_PASSE: 
			etat=new Nonpasse();
			break;
		
		case FUTUR:
			etat=new Future();
			break;
			
		case ANCIEN:
			
			etat=new Ancien();
			break;
		
		
		
		}
		return etat;
		
	}
	
	public static Etat getEtatFutur() {
		
		return new Future();
	}

	public static Etat getEtatAncien() {
		
		return new Ancien();
	}
	
	public static Etat getEtatNonPasse() {
		
		return new Nonpasse();
	}
}	
	