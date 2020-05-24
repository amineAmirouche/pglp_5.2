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
	
	public void CreatePersonnelDAO(Personnel s)
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

}
