package lesschtroumpfs;

import java.util.ArrayList;

public class Village {
	private String nom;
	private ArrayList <Schtroumpf> peuple = new ArrayList<Schtroumpf>();
	private int habitants;
	private int stock;

	public Village (String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.habitants = pfNomsDesSchtroumpfs.length;

		for (int i = 0; i < this.habitants; i++) {
			int age = (int)(Math.random()*150);
			Schtroumpf temp = new Schtroumpf(pfNomsDesSchtroumpfs[i], age, this);
			this.peuple.add(temp);
		}
		this.stock = pfStockSalsepareille;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbSchtroumpf() {
		return this.habitants;
	}
	
	public int getStockSalsepareille() {
		return this.stock;
	}
	
	public void solstice_d_ete() {
		System.out.println("Aujourd'hui � lieux la grande f�te du solstiste d'�t� au village "+this.getNom());
		System.out.print(this.getNbSchtroumpf()+" schtroumpfs sont pr�sent � cet �v�nement incomparable, ");
		int heureux = 0;
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			if (this.peuple.get(i).estContent())
				heureux ++;
		}
		System.out.println("dont "+heureux+" contents.");
		
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			this.peuple.get(i).sePresenter();
			this.peuple.get(i).chanter();
		}
	}
	
	public Schtroumpf chefDuVillage() {
		Schtroumpf chef = this.peuple.get(0);
		for (int i = 1; i < this.getNbSchtroumpf(); i++) {
			if (this.peuple.get(i).getAge() > chef.getAge())
				chef = this.peuple.get(i);
		}
		return chef;
	}
	
	public void envoyerAuTravail () {
		boolean atravailler = true;
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			if (this.peuple.get(i).estContent())
				if (!atravailler) {
					this.peuple.get(i).allerTravailler();
					atravailler = true;
				} else
					atravailler = false;
		}
	}
	
	public void schtroumpsfHeureux () {
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			if (this.peuple.get(i).estContent())
				this.peuple.get(i).sePresenter();
		}
	}
	
	public void dinerTousEnsemble() {
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			this.peuple.get(i).dinerAuVillage();
		}
	}
	
	public void envoyerCueillirSalsepareille() {
		boolean atravailler = true;
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			if (this.peuple.get(i).estContent())
				if (!atravailler) {
					this.peuple.get(i).recolterSalsepareille();
					atravailler = true;
				} else
					atravailler = false;
		}
	}
	
	public void changerStock(int pfQte) {
		this.stock += pfQte;
	}
}
