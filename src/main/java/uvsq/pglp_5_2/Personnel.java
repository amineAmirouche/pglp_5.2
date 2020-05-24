package uvsq.pglp_5_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public final class Personnel implements GroupePersonnels,Serializable {
	
	private  String Nom;
	private  String Prenom;
	private  String Post;
	private  java.time.LocalDate Date;
	private  ArrayList<Integer> Tel;
	
	Personnel(Builder build)
	{
		Nom=build.Nom;
		Prenom=build.Prenom;
		Post=build.Post;
		Date=build.Date;
		Tel=build.Tel;
	}
	
	public ArrayList<Integer> GetTel()
	{
		return this.Tel;
	}
	
	public String GetNom()
	{
		return this.Nom;
	}
	
	public String GetPrenom()
	{
		return this.Prenom;
	}
	
	public String GetDate()
	{
		return this.Date.toString();
	}
	
	
	
	public void serialise(String fileDest)
	{
		 ObjectOutputStream oos = null;

		    try {
		      final FileOutputStream fichier = new FileOutputStream(fileDest);
		      oos = new ObjectOutputStream(fichier);
		      oos.writeObject(this);
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
	
	public static Personnel deserialise(String Fsource)
	{
		Personnel e=null;
		try {
	         FileInputStream fileIn = new FileInputStream(Fsource);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Personnel) in.readObject();
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
		
	
	
	
	public static class Builder {
		
		private final String Nom;
		private final String Prenom;
		private final java.time.LocalDate Date;
		
		private  String Post="inconnue";		
		private  ArrayList<Integer> Tel=new ArrayList<Integer>();
		
		
		public Builder(String Nom,String Prenom,java.time.LocalDate Date)
		{
			this.Date=Date;
			this.Nom=Nom;
			this.Prenom=Prenom;
		}
		
		public Builder AddTel(int numero)
		{
			this.Tel.add(numero);
			return this;
		}
		
		
		public Personnel build()
		{
			return new Personnel(this);
		}
	}
	public void print() {
		System.out.println("Nom du personnel" + Nom + Prenom );
		
	}
	

}
