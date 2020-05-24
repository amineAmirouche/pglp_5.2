package uvsq.pglp_5_2;

import java.util.ArrayList;

public class CompositePersonnelSerialDAO implements DAO<CompositePersonnels>{

	/**
	 *sérialisation du composite 
	 */
	@Override
	public boolean create(CompositePersonnels obj) {
		CompositePersonnels groupe1=new CompositePersonnels();
		groupe1.add(obj);
		groupe1.serialise("./BD.txt");
		return true;
	}

	@Override
	public boolean read(String id) {
		
		return false;
	}

	

	/**
	 *obj a été serialisé au paravent , puis a subit des traitement donc pour mettre a jour sa serialisation
	 *il suffit de recupérer une copie du nouvel obj , deserialiser ce qu'il y'a dans le fichier , pour reserialiser
	 *avec le nouveau contenu
	 */
	@Override
	public boolean update(CompositePersonnels obj)
	{
		CompositePersonnels copie=obj;
		obj=obj.deserialise(obj.path);
		copie.serialise(obj.path);
		return true;
	}

	/**
	 *déserialisation du obj 
	 */
	@Override
	public boolean delete(CompositePersonnels obj) {
		obj=obj.deserialise(obj.path);
		return false;
	}
	
	

}
