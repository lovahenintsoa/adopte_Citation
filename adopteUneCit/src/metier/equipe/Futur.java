package metier.equipe;

import java.time.LocalDate;

public class Futur extends Passe {
	private LocalDate datePassage;

	public Futur() {
		super(EtatDeveloppeur.FUTUR);
	}
	
	@Override
	protected boolean isFutur() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isAncien() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isNonPasse() {
		// TODO Auto-generated method stub
		return false;
	}


	

}
