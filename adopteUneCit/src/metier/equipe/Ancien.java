package metier.equipe;

public class Ancien extends Passe {

	
	public Ancien() {
		super(EtatDeveloppeur.ANCIEN);
	}
	
	
	@Override
	protected boolean isFutur() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isAncien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isNonPasse() {
		// TODO Auto-generated method stub
		return false;
	}


}
