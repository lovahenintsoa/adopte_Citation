package metier.equipe;

public abstract class Etat {
//	private int id;
//	private String libelle;
	private EtatDeveloppeur etatDeveloppeur;
	
	public Etat(EtatDeveloppeur etatDeveloppeur) {
	
		this.etatDeveloppeur = etatDeveloppeur;
	}

	public int getId() {
		return  etatDeveloppeur.getId();
	}
	
	public String getLibelle() {
		return etatDeveloppeur.getLibelle();
	}
	
	@Override
	public String toString() {
		return "Etat [getId()=" + getId() + ", getLibelle()=" + getLibelle() + "]";
	}
	
	
	protected abstract boolean isFutur();
	
	protected abstract boolean isAncien();
	
	protected abstract boolean isNonPasse();


	
	
	

}
