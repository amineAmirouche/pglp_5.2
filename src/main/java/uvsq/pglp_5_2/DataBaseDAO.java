package uvsq.pglp_5_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseDAO {
	String url;
	
	
	/**
	 * @param url: correspondant a la connection a la bd pour la creation des tables
	 */
	public DataBaseDAO(String url)
	{
		this.url=url;
		}
	
	/**
	 * @param url:url de la base de donnée avec le create:true ajouté afin de créer la base
	 */
	public void CreateDataBase (String url)
	{
		try {
			Connection conn=DriverManager.getConnection(url);
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Methode qui permet de crée les tables associées à personnel et compositePersonnel
	 */
	public void CreateTables()
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			Statement statement = conn.createStatement(); 
			statement.executeQuery("CREATE TABLE PERSONNEL(nom VARCHAR(30),prenom VARCHAR(30),post VARCHAR(30),date VARCHAR(30),tel VARCHAR(30))");
			
			statement.executeQuery("CREATE TABLE COMPOSITE(nom VARCHAR(30),prenom VARCHAR(30),id VARCHAR(30))");
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
