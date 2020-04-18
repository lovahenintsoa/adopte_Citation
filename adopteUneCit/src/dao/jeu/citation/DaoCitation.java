package dao.jeu.citation;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.jeu.citation.Theme;
import metier.jeu.citation.Themes;
import service.exception.UserException;
import util.message.MessageAppli;

/**
 * 
 * connexion à la base de données testlova
 *
 */
public class DaoCitation {

	private final String BDD 		= "testlova";
	private final String USER 		= "tsoa";
	private final String PASSWD		="Amical2020";
	private final String DBURL 		= "jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" + 
	  "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver";

	
	public void creer(Theme theme) throws UserException {
		System.out.println("DaoCitation - creer");
		// control
		
		
		// acces BDD
		try {
			// 1 - verification de la presence du driver
			Class.forName(strNomDriver);
			
			// 2 - on ouvre la connexion
			Connection conn        = DriverManager.getConnection(DBURL, USER, PASSWD);
			//Statement stmt 		   = conn.createStatement();
			
			// String reqSql = "insert into theme values (  101   ,'   vive Domixxx    ')";
			//String reqSql = "insert into theme values ("  + theme.getId() + ",'" + theme.getLibelle() + "')";
		
			//System.out.println("requete : " + reqSql);
			//int nbRow = stmt.executeUpdate(reqSql); 
			
			
			// insertion dans la base en utilisant RequeteSql
			PreparedStatement stmt = conn.prepareStatement(RequeteSql.INSERT_THEME );
			stmt.setInt(1, theme.getId());	
			stmt.setString(2, theme.getLibelle());
			
			int nbRow=stmt.executeUpdate();
			
			
			// gestion d'erreur cas nominal
			// on utilise String.format en utilisant les %d et%s de MessageAppli.CREER_THEME_OK
			if ( nbRow==1 ) throw new UserException(String.format(MessageAppli.CREER_THEME_OK,theme.getId(), theme.getLibelle()));
			
			    		
		} catch(ClassNotFoundException e)  {
			throw new UserException(MessageAppli.ERREUR_BDD);
		} catch (SQLException e) {
			
			if      (e.getMessage().contains(ContrainteMySql.PK_THEME)) 		throw new UserException(MessageAppli.ID_EXISTANT);
			else if (e.getMessage().contains(ContrainteMySql.UN_THEME_LIBELLE)) throw new UserException(MessageAppli.LIBELLE_THEME_DOUBLON);
			else throw new UserException(MessageAppli.ERREUR_BDD);
//			System.out.println("SQLSTATE   : " + e.getSQLState());
//			System.out.println("MESSAGE    : " + e.getMessage());
//			System.out.println("ERROR CODE : " + e.getErrorCode());
//			System.out.println("LOCAL MSG  : " + e.getLocalizedMessage());
		} 

	}
	
	public Themes getThemes() {
		Themes themes = new Themes();
		try {
			Class.forName(strNomDriver); // verifie si le sql jar existe
			Connection 	conn = DriverManager.getConnection (DBURL, USER, PASSWD);
			
			Statement stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery ("select id_the,lib_the from theme");
			
			while( rs.next()) {
				Integer id = rs. getInt ("id_the");
				String lib = rs. getString("lib_the");
				
			    Theme theme1 =new Theme(id,lib);
			    themes.add(theme1);
			   
				//System.out.println ("Resultat select : " + i + " " + s );
				}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return themes;
		
	}
	
	public void doSuppression(int idTheme) throws UserException {
		System.out.println("vous etes ici service DAO " + idTheme);
		
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			//String sql = "DELETE FROM theme WHERE id_the = "+idTheme;
			PreparedStatement stmt = conn.prepareStatement(RequeteSql.SUPPR_THEME);
			stmt.setInt(1, idTheme);
			//stmt.setInt(1, 20);
			int nbRow=stmt.executeUpdate();
			
		//	if ( nbRow==0 ) throw new UserException(String.format(MessageAppli.ID_INEXISTANT));
		} catch (ClassNotFoundException e) {
			throw new UserException(MessageAppli.ERREUR_BDD);
		} catch (SQLException e) {
			if      (e.getMessage().contains(ContrainteMySql.FK_THEME)) 		throw new UserException(MessageAppli.FK_CIT_THEME);
			
		}
		
		
	}

}
