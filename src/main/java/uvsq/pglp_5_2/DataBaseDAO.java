package uvsq.pglp_5_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseDAO {
	String url;
	
	
	public DataBaseDAO(String url)
	{
		this.url=url;
		}
	
	public void CreateDataBase (String url)
	{
		try {
			Connection conn=DriverManager.getConnection(url);
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void CreateTables()
	{
		
		
		
	}

}
