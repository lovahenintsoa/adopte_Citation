package dao.equipe;

public class RequeteSql {

	protected static final String SELECT_DEVS_BY_ETAT_ORDER_PRENOM = "select id_dev, pse_dev, nom_dev, pre_dev, img_dev "
																   + "from developpeur where id_for = ? and id_eta = ? "
																   + "order by pre_dev;";


	
	
}
