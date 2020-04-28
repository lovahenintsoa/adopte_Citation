package dao.jeu.citation;

public class RequeteSql {
	protected final static String INSERT_THEME= "insert into theme (id_the,lib_the)values (?,?)";
	protected final static String SUPPR_THEME=  "DELETE FROM theme WHERE id_the =" +"?" ;
	protected final static String INSERT_CITATION= "Insert into citation (id_cit,id_the,id_dev,txt_cit,dat_cit,img_cit)values (?,?,?,?,?,?)";
}
