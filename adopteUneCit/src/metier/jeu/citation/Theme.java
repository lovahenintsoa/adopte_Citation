package metier.jeu.citation;

public class Theme {
	
	private int id;
	private String libelle;
	
	
	public Theme(int idTheme, String libelle) {
		this.id = idTheme;
		this.libelle = libelle;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", libelle=" + libelle + "]";
	}
	
	

}
