package uvsq.pglp_5_2;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     * On crée la bd et les tables , on crée un personnel via le builder , on le stock dans la bd et on verifie l'affichage de la table
     */
    public static void main( String[] args )
    {
    	String url="jdbc:derby:Bdpglp;create=true";
    	String url2="jdbc:derby:Bdpglp";
    	DataBaseDAO database=new DataBaseDAO(url2);
    	database.CreateDataBase(url);
    	 database.CreateTables();
    	   Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).AddTel(352).build();
    	PersonnelsDAO personneldao=new PersonnelsDAO(url2);
    	personneldao.CreatePersonnel(p1);
    	personneldao.AffichePersonnels();
    	
    	
    }
}
