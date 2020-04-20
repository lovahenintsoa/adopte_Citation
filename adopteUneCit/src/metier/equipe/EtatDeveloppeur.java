package metier.equipe;

public enum EtatDeveloppeur {

	NON_PASSE(1,"Non passe"),FUTUR(2,"Futur"),ANCIEN(3,"Ancien");
	private int id;
	private String libelle;
	
	 EtatDeveloppeur(int id,String libelle) {
		this.id=id;
		this.libelle=libelle;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}
}
