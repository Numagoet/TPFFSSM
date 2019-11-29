package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {
    
        private List<Licence> licences = new LinkedList<>();
	
	private int niveau = 0;
	
	private GroupeSanguin groupe = GroupeSanguin.APLUS;	
	
	public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, Licence l) {
		super(numeroINSEE, nom, prenom, adresse, telephone, naissance);

		licences.add(l);
	}	
	
	public void ajouteLicence(Licence l) {
		if (null == l)
			throw new IllegalArgumentException("l is null");
		licences.add(l);		
	}
	
	public Licence derniereLicence() {
		return licences.get(licences.size() - 1);
	}

	public GroupeSanguin getGroupe() {
		return groupe;
	}

	public void setGroupe(GroupeSanguin groupe) {
		this.groupe = groupe;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
}

