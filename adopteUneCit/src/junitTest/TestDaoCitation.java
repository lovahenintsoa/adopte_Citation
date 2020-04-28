package junitTest;




import java.sql.Connection;

import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dao.jeu.citation.DaoCitation;
import metier.equipe.Developpeur;
import metier.equipe.Formation;
import metier.jeu.citation.Citation;
import metier.jeu.citation.Theme;
import service.exception.UserException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;




class TestDaoCitation {

	private final String BDD 		= "testlova";
	private final String USER 		= "tsoa";
	private final String PASSWD		="Amical2020";
	private final String DBURL 		= "jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" + 
	  "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver";
	private LocalDate  localdate;
	private static Developpeur arash;
	private static Theme theme;
	private static Citation citation1;
	private static Citation citation2;
	private static Formation formation;
	private static DaoCitation daoCitation;
	//private static UserException userexception;
	
	@BeforeAll
	static void debutClasse() throws Exception {
		daoCitation = new DaoCitation();
		
		formation = new Formation(1, "dev mobile");
		arash = new Developpeur(7, "persusM", "Bazdar", "Arash", formation);
		theme = new Theme(1, "Humour");
		
	}

	@BeforeEach
	void debut() throws Exception {
		// idem setUp
		
		
		citation1 = new Citation(1,"citation 1 ",LocalDate.now(),"image.jpg",theme,arash);
		citation2 = new Citation(1,"citation 2 ",LocalDate.now(),"image1.jpg",theme,arash);
		System.out.println("Execution de debut()");		
	}

	@AfterEach
	void fin() throws Exception {
	
	}

	@AfterAll
	static void finClasse() throws Exception {
		
	
	}
	
	
	
	
	@Test
	void testCreerCitation() {
		fail("Not yet implemented");
	}

	@DisplayName("cas nominal")
	@Test
//	void testCasNominal() {
//	
//	 UserException userexception= assertThrows (UserException.class,() -> {
//			daoCitation.creer1(citation1);
//		});
//		assertTrue(userexception.getMessage().contains("OK"));
//	}
	
	void testCasNominal() {
		
		 UserException userexception= assertThrows (UserException.class,() -> {
				daoCitation.creer(citation1);
			});
			assertTrue(userexception.getMessage().contains("La Citation a été inséré."));
		}
	
	

	void IdUniqueCreerCitation() throws UserException{
	
	}
}
