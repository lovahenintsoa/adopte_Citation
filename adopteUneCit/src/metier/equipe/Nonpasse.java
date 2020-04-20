package metier.equipe;

public class Nonpasse extends Etat {

	public Nonpasse() {
		super(EtatDeveloppeur.NON_PASSE);
	
	}

	@Override
	protected boolean isFutur() {

		return false;
	}

	@Override
	protected boolean isAncien() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isNonPasse() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
