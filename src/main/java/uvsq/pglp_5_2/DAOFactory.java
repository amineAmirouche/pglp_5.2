package uvsq.pglp_5_2;

public class DAOFactory {
	/*public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelSerialDAO();
	}*/
	
	public DAO<CompositePersonnels> getPersonnelGroupeDAO() {
		return new CompositePersonnelSerialDAO();
	}

}
