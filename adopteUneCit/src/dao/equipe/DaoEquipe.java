package dao.equipe;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.jeu.citation.ContrainteMySql;
import dao.jeu.citation.RequeteSql;
import metier.equipe.Developpeur;
import metier.equipe.Developpeurs;
import metier.equipe.Etat;
import metier.equipe.EtatDeveloppeur;
import metier.equipe.FabriqueEtat;
import metier.equipe.Formation;
import metier.jeu.citation.Theme;
import service.exception.UserException;
import util.message.MessageAppli;

public class DaoEquipe {
	
	private final String BDD 		= "testlova";
	private final String USER 		= "tsoa";
	private final String PASSWD		="Amical2020";
	private final String DBURL 		= "jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" + 
	  "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver";
	private final String MSG_DAO_BDD = "***DM SQLException - DaoEquipe - Methode %s - SQLSTATE %s CodeError %d - %s";

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

	public boolean isConnexionDeveloppeurOK(String pseudo, String pw) {
		//System.out.println("dao ici");
		boolean ok = false;
		
		try {
			Class.forName(strNomDriver); // verifie si le sql jar existe
			Connection 	conn = DriverManager.getConnection (DBURL, USER, PASSWD);
			
			PreparedStatement stmt = conn.prepareStatement(dao.equipe.RequeteSql.IS_CONN_DEV_OK);
			stmt.setString(1, pseudo);	
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();// qd SELECT
		  
			while(rs.next()) {
				ok=rs.getBoolean(1);
			
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return ok;
	}



	public Developpeur getDeveloppeurByPseudo(String pseudo) throws UserException {
		Developpeur developpeur=null;
		
if (pseudo == null || pseudo.isBlank()) throw new UserException(MessageAppli.DEV_PSEUDO_PW_INCONNU);
		
		try {
			Class.forName(strNomDriver);
			Connection conn  = DriverManager.getConnection(DBURL, USER, PASSWD);

			// requete d'appel de la fonction
			String sql       	 = dao.equipe.RequeteSql.SELECT_DEVELOPPEUR_BY_PSEUDO;
			PreparedStatement ps = conn.prepareStatement(sql);

			// recuperer le developpeur
			// pseudo
			ps.setString(1,pseudo.strip());	
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// select id_dev, pse_dev, nom_dev, pre_dev, img_dev, id_eta, id_for, lib_for 
				int id 					= rs.getInt("id_dev");
				String nom 				= rs.getString("nom_dev");
				String prenom 			= rs.getString("pre_dev");
				String image 			= rs.getString("img_dev");
				int idEtat 				= rs.getInt("id_eta");
				int idFormation 		= rs.getInt("id_for");
				String libelleFormation = rs.getString("lib_for");
				
				// reconstruire l'objet Formation
				Formation formation = new Formation(idFormation, libelleFormation);
				// reconstruire l'objet Etat
				Etat etat = FabriqueEtat.getEtat(idEtat);
				// reconstruire le developpeur
				developpeur = new Developpeur(id, pseudo, nom, prenom, formation, image);
				developpeur.setEtat(etat);	
				System.out.println("dao" + developpeur);
			}
			ps.close();

		} catch (ClassNotFoundException e1) {
			throw new UserException(MessageAppli.ERREUR_BDD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException(String.format(MSG_DAO_BDD, "getDeveloppeurByPseudo(String pseudo)",e.getSQLState(),e.getErrorCode(), e.getMessage()));
		} 
			
		return developpeur;
	}
	
}
