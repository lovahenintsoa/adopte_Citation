package dao.equipe;

public class RequeteSql {

	protected static final String SELECT_DEVS_BY_ETAT_ORDER_PRENOM = "select id_dev, pse_dev, nom_dev, pre_dev, img_dev "
																   + "from developpeur where id_for = ? and id_eta = ? "
																   + "order by pre_dev;";


	protected final static String IS_CONN_DEV_OK= "select isConexionDevelopeurOK(?,?)"; 
	
	
	protected static final String  SELECT_DEVELOPPEUR_BY_PSEUDO ="select id_dev,pse_dev,nom_dev,pre_dev,img_dev,id_eta,d.id_for,lib_for "
																+ "from developpeur d inner join formation f on d.id_for=f.id_for "
																+ "where pse_dev=?";
}
