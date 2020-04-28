package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;


public class Appli4 {
	
	public static void main(String[] args) {
		
		final String STR_NOM_DRIVER	= "com.mysql.cj.jdbc.Driver";		
		final String BDD 			= "testdomi";
		final String USER 			= "muller";
		final String PASSWD 		= "codapppw";
		final String DBURL 			="jdbc:mysql://localhost:3306/" + BDD + "?"
									+ "user=" + USER 
									+ "&password=" + PASSWD 
									+ "&useUnicode=true"  
							  		+ "&useJDBCCompliantTimezoneShift=true"
							  		+ "&useLegacyDatetimeCode=false" 
							  		+ "&serverTimezone=UTC";	
		
		
		try {
			Class.forName(STR_NOM_DRIVER);
			Connection conn        = DriverManager.getConnection(DBURL);
			
			// attention : 4 parametres
			String sql = "{call procInsertTest(?,?,?,?)}";
			CallableStatement callStmt = conn.prepareCall(sql);
			
			callStmt.setString(1, "Produit 0");
			callStmt.setFloat (3, 20.52f);
			callStmt.setInt   ("in_qte", 10);			// parameter name
			
			// Il faut enregistrer les parametres en out
			// attention, ce sont les types sql
			callStmt.registerOutParameter(1, Types.VARCHAR);	// = 12
			callStmt.registerOutParameter("out_total", Types.DECIMAL);
			
			/*
			 * Executes the SQL statement in this PreparedStatement object,which may be any kind of SQL statement.
			 * Some prepared statements return multiple results; 
			 * the execute method handles these complex statements as well as the simpler form of statements 
			 * handled by the methods executeQuery and executeUpdate. 
			 *
			 * The execute method returns a boolean to indicate the form of the first result. 
			 * You must call either the method getResultSet or getUpdateCount to retrieve the result; 
			 * you must call getMoreResults to move to any subsequent result(s).
			 */
			boolean hadResults = callStmt.execute();		// execute et non executeQuery ou executeUpdate
			
			// ======================
			// traitement des resultats	
			// ======================
			
		    while (hadResults) {
		        ResultSet rs = callStmt.getResultSet();
		        
		        ResultSetMetaData rsmd = rs.getMetaData();
		        String name 	= rsmd.getColumnName(1);
		        int nbColonnes 	= rsmd.getColumnCount();
		        System.out.println("Nom de la 1ère colonne : " + name + " - Nb de colonnes : " + nbColonnes);
		        
		        while(rs.next()){
		        	if (name.equals("rs1")) {
		        		String 	produit 	= rs.getString("produit");
						Integer qte 		= rs.getInt( "qte");
						float 	prix 		= rs.getFloat("prix");
						System.out.println("Resultat select1 : " + produit + " " + qte + " " + prix);
		        	}
		        	else if (name.equals("rs2")) {
		        		String 	produit 	= rs.getString("produit");
						float 	total 		= rs.getFloat(3);
						System.out.println("Resultat select2 : " + produit + " " + total);
		        	}
		        	else System.out.println("Resultset inconnu");
		        	
					
				}

		        System.out.println("\n had more?");
		        hadResults = callStmt.getMoreResults();
		    }
			
			// recuperation des parametres en out ou inout
			float prix = callStmt.getFloat(4);
			String produit = callStmt.getString(1);
			System.out.println("\nLes paramètres en out ou inout : " + produit + " - " + prix);
			
		} catch(ClassNotFoundException e){ 						
			System.err.println("Erreur 1 : " + e); 
		} catch (SQLException s){ 								
			System.err.println("Erreur 2 : " 
				    + " SQLException: " 	+ s.getMessage()
				    + " SQLState: " 		+ s.getSQLState()
				    + " VendorError: " 	+ s.getErrorCode());
		}
		System.out.println("Fin pgm");
	}

}

