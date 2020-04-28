package metier.jeu.citation;

import java.time.LocalDate;

import metier.equipe.Developpeur;

public class Citation {
	private int id;
	private String texte;
	private LocalDate dateCreation;
	private String imageCitation;
	private Theme theme;
	private Developpeur developpeur;

	
	
	
	public Citation(int id, String texte, LocalDate dateCreation, String imageCitation, Theme theme,
			Developpeur developpeur) {
		super();
		this.id = id;
		this.texte = texte;
		this.dateCreation = dateCreation;
		this.imageCitation = imageCitation;
		this.theme = theme;
		this.developpeur = developpeur;
	}


	public Citation(int id, String texte, LocalDate dateCreation, String imageCitation) {
	
		this.id = id;
		this.texte = texte;
		this.dateCreation = dateCreation;
		this.imageCitation = imageCitation;
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTexte() {
		return texte;
	}


	public void setTexte(String texte) {
		this.texte = texte;
	}


	public LocalDate getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}


	public String getImageCitation() {
		return imageCitation;
	}


	public void setImageCitation(String imageCitation) {
		this.imageCitation = imageCitation;
	}


	@Override
	public String toString() {
		return "Citation [id=" + id + ", texte=" + texte + ", dateCreation=" + dateCreation + ", imageCitation="
				+ imageCitation + "]";
	}


	public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}


	public Developpeur getDeveloppeur() {
		return developpeur;
	}


	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}
	
	

}
