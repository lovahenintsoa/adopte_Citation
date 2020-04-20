package test;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class appli2 {
	
	public static void main(String[] args) {
		
		final String STR_NOM_DRIVER	= "com.mysql.cj.jdbc.Driver";		
		final String BDD 			= "testlova";
		final String USER 			= "tsoa";
		final String PASSWD 		= "Amical2020";
		final String DBURL 			="jdbc:mysql://localhost:3306/" + BDD + "?"
									+ "user=" + USER 
									+ "&password=" + PASSWD 
							  		+ "&serverTimezone=UTC";	
		
		
		try {
			Class.forName(STR_NOM_DRIVER);
			Connection conn        = DriverManager.getConnection(DBURL);
			
			String sql = "{call procInsertTest(?,?,?)}";
			CallableStatement callStmt = conn.prepareCall(sql);
			
			callStmt.setString(1, "Produit 0");
			callStmt.setFloat (3, 20.52f);
			callStmt.setInt   ("in_qte", 10);			// parameter name
			
			int nb = callStmt.executeUpdate();
			System.out.println(nb + " insert effectue.");
			
			// ======================
			// verification des resultats	
			// ======================		
			ResultSet rs = conn.createStatement().executeQuery("select produit, qte, prix from test");
			
			// lecture du resultset
			while(rs.next()){
				String 	produit 	= rs.getString("produit");
				Integer qte 		= rs.getInt( "qte");
				float 	prix 		= rs.getFloat("prix");
				System.out.println("Resultat select : " + produit + " " + qte + " " + prix);
			}
			
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
