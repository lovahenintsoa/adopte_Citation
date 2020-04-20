package dao.equipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.jeu.citation.ContrainteMySql;
import dao.jeu.citation.RequeteSql;
import metier.equipe.Developpeur;
import metier.equipe.Developpeurs;
import metier.equipe.EtatDeveloppeur;
import metier.equipe.FabriqueEtat;
import metier.equipe.Formation;
import service.exception.UserException;
import util.message.MessageAppli;

public class DaoEquipe {
	
	private final String BDD 		= "testlova";
	private final String USER 		= "tsoa";
	private final String PASSWD		="Amical2020";
	private final String DBURL 		= "jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" + 
	  "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver";

	public Developpeurs getDevPasseTriePrenom(Formation formation) throws UserException {
		Developpeurs developpeursPasses =new Developpeurs();
		try {
			// 1 - verification de la presence du driver
			Class.forName(strNomDriver);
			
			// 2 - on ouvre la connexion
			Connection conn        = DriverManager.getConnection(DBURL, USER, PASSWD);
			//Statement stmt 		   = conn.createStatement();
			
			
		 String sql = dao.equipe.RequeteSql.SELECT_DEVS_BY_ETAT_ORDER_PRENOM;
			
			// insertion dans la base en utilisant RequeteSql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, formation.getId());
			ps.setInt(2,EtatDeveloppeur.ANCIEN.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String pseudo= rs.getString("pse_dev");
				String nom= rs.getString("nom_dev");
				String prenom= rs.getString("pre_dev");
				String imagePortrait= rs.getString("img_dev");
				Developpeur developpeur = new Developpeur(id,pseudo,nom,prenom,formation);
				developpeur.setEtat(FabriqueEtat.getEtat(EtatDeveloppeur.ANCIEN));
				developpeur.setImagePortrait(imagePortrait);
				
				developpeursPasses.add(developpeur);
			}
			
		
			
			
			// gestion d'erreur cas nominal
			// on utilise String.format en utilisant les %d et%s de MessageAppli.CREER_THEME_OK
			
			
			    		
		} catch (ClassNotFoundException e) {
			throw new UserException(MessageAppli.ERREUR_BDD);
		} catch (SQLException e) {
			throw new UserException(MessageAppli.RECUP_DEV_PASSES_KO);
		} 	
		
		return developpeursPasses;
	}
	
	

	public Developpeurs getDevNonPasseTriePrenom(Formation formation) {
		Developpeurs developpeursNonPasses =null;
		
		//
		return developpeursNonPasses;
	}

	
	
}
