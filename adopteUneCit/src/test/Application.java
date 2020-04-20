package test;

import metier.equipe.Developpeur;
import metier.equipe.FabriqueEtat;

public class Application {

	public static void main(String[] args) {
		
		Developpeur developpeur1 = new Developpeur(1,"zorro", "LovaFu","tsoa", null);
		Developpeur developpeur2 = new Developpeur(1,"zorro", "Lovanp","tsoa", null);
		Developpeur developpeur3 = new Developpeur(1,"zorro", "LovaAnc","tsoa", null);
		
	
		boolean estunFutur=developpeur1.isFutur();
		boolean estunNpasse=developpeur1.isNonPasse();
		boolean estunAncien=developpeur1.isAncien();
		
		System.out.println(developpeur1.getNom()+  " est il un futur reponse : "+estunFutur);
		System.out.println(developpeur1.getNom()+  " est il un futur reponse : "+estunNpasse);
		System.out.println(developpeur1.getNom()+  " est il un futur reponse : "+estunAncien);
		

	}

}
