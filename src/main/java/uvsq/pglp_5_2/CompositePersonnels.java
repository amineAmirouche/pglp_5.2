package uvsq.pglp_5_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CompositePersonnels implements GroupePersonnels,Serializable {

	
	String path;
	ArrayList<GroupePersonnels> personnes; 
	//int IdGroupe;
	
	public CompositePersonnels()
	{
		//this.IdGroupe=id;
		this.personnes=new ArrayList<GroupePersonnels>();
	}
	public void add(GroupePersonnels groupe)
	{
		personnes.add(groupe);
	}
	public void serialise(String Dest)
	{
		 ObjectOutputStream oos = null;

		    try {
		      final FileOutputStream fichier = new FileOutputStream(Dest);
		      if (fichier==null)
		      {
		    	  System.out.println("le fichier est nul");
		      }
		      oos = new ObjectOutputStream(fichier);
		      oos.writeObject(this);
		      this.path=Dest;
		      
		      oos.flush();
		    } catch (final java.io.IOException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        if (oos != null) {
		          oos.flush();
		          oos.close();
		        }
		      } catch (final IOException ex) {
		        ex.printStackTrace();
		      }
		    }
		  }
	
	public static CompositePersonnels deserialise(String Dest)
	{
		CompositePersonnels e=null;
		try {
	         FileInputStream fileIn = new FileInputStream(Dest);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (CompositePersonnels) in.readObject();
	         in.close();
	         fileIn.close();
	         return e;
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         c.printStackTrace();
	         return null;
	      }
	    
	}
	
	public void remove(GroupePersonnels groupe)
	{
		personnes.remove(groupe);
	}
	
	public ArrayList<GroupePersonnels> GetList()
	{
		return this.personnes;
	}
 	
	
	public void print() {
		for (GroupePersonnels groupePersonnels : personnes)
			{
			groupePersonnels.print();
			}
	}
			
		
	}

