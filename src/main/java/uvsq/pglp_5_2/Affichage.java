package uvsq.pglp_5_2;

import java.util.ArrayList;
import java.util.Iterator;

public class Affichage {
	ArrayList<GroupePersonnels> grp=new ArrayList<GroupePersonnels>();
	GroupePersonnels groupe;
	
	
	public Affichage(GroupePersonnels p)
	{
		groupe=p;
	}
	
	public Iterator iterator()
	{
		return new GrpIterator();
	}
	
	private class GrpIterator implements Iterator {
		int index;

		public GrpIterator()
		{
			int indice=0;
			while(indice<=grp.size())
			{ 	
				grp.add(groupe);
				indice++;
			if(groupe instanceof CompositePersonnels)
			for(int i=0;i<((CompositePersonnels) groupe).personnes.size();i++)
			{
				grp.add(((CompositePersonnels) groupe).personnes.get(i));
			}
			}
			
		}
		public boolean hasNext() {
			if(index>=grp.size())
			return false; else return true;
		}

		public Object next() {
			return grp.get(index++);
		}
		
		
	}

}
