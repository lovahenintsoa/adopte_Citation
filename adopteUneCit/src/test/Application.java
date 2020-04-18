package test;

import metier.equipe.Developpeur;

public class Application {

	public static void main(String[] args) {
		Developpeur developpeur = new Developpeur(1,"zorro", "Lova","tsoa", null);
		
		
		boolean resp=developpeur.isFutur();
		
		System.out.println(developpeur.getNom()+  " est il un futur reponse : " + resp);
		
		

	}

}
