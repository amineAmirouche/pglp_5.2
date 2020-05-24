package uvsq.pglp_5_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonnelsDAO {
	String url;
	
	public PersonnelsDAO(String url)
	{
		this.url=url;
	}
	
	/**
	 * @param s:le personnel a insérer
	 * une methode qui insert un personnel dans la table PERSONNEL
	 */
	public void CreatePersonnel(Personnel s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("insert into PERSONNEL(nom,prenom,post,date,tel) values(?,?,?,?,?)");
			statement.setString(1, s.GetNom());
			statement.setString(2, s.GetPrenom());
			statement.setString(3, s.GetPost());
			statement.setString(4, s.GetDate());
			statement.setString(5, s.GetTel().get(0).toString());
			statement.execute();
			statement.close();
			conn.close();
			return;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param s:Personnel souhaité a mettre a jour
	 * methode qui permet de mettre a jour dans la bd le personnel s
	 */
	public void UpdatePersonnel(Personnel s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("update PERSONNEL Set prenom=?, post=? where nom=?");
			statement.setString(1, s.GetPrenom());
			statement.setString(2, s.GetPost());
			statement.setString(3, s.GetNom());
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
