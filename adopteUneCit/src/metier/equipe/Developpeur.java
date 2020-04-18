package metier.equipe;

import java.time.LocalDate;

public class Developpeur {
	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String motDePasse;
	private LocalDate dateInscription;
	private Formation formation;
	public Etat etat;
	
	
	public Developpeur(int id, String pseudo, String nom, String prenom, Formation formation) {

		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.formation = formation;
		//setEtat(new Nonpasse());
		setEtat(new Future());
	}
	
	
	
	
	
	public Developpeur(int id, String pseudo, String nom, String prenom, String motDePasse, LocalDate dateInscription,
			Formation formation) {
	
		this(id, pseudo, nom, prenom, formation);
//		this.id = id;
//		this.pseudo = pseudo;
//		this.nom = nom;
//		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.dateInscription = dateInscription;
//		this.formation = formation;

		setEtat(new Ancien());
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public LocalDate getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	
	public boolean isFutur() {
		return etat.isFutur();
	}

}
