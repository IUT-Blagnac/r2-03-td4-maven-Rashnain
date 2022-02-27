package lesschtroumpfs;

import java.util.ArrayList;

/**
 * Classe définissant le type Village
 * @author Guibert Rémy
 */
public class Village {
	private String nom;
	private ArrayList <Schtroumpf> peuple = new ArrayList<Schtroumpf>();
	private int habitants;
	private int stock;

	/** Constructeur
	 * Asigne au Village un nom, stock de salsepareille et des nouveaux Schtroumpfs
	 * @param pfNomV IN : nom du Village
	 * @param pfStockSalsepareille IN : stock de salsepareille du Village
	 * @param pfNomsDesSchtroumpfs IN : tableau des noms de Schtroumpfs à générer
	 */
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
	
	/** Renvoit le nom du Village
	 * @return nom du Village
	 */
	public String getNom() {
		return this.nom;
	}
	
	/** Renvoit le nombre de Schtroumpf dans le Village
	 * @return nombre de Schtroumpf dans le Village
	 */
	public int getNbSchtroumpf() {
		return this.habitants;
	}
	
	/** Renvoit le nombre de salsepareille dans le Village
	 * @return nombre de salsepareille dans le Village
	 */
	public int getStockSalsepareille() {
		return this.stock;
	}
	
	/** Fête le solsiste d'été
	 */
	public void solstice_d_ete() {
		System.out.println("Aujourd'hui à lieux la grande fête du solstiste d'été au village "+this.getNom());
		System.out.print(this.getNbSchtroumpf()+" schtroumpfs sont présent à cet évènement incomparable, ");
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
	
	/** Renvoit l'adresse mémoire du chef du Village
	 * @return adresse mémoire du Schtroumpf le plus agé
	 */
	public Schtroumpf chefDuVillage() {
		Schtroumpf chef = this.peuple.get(0);
		for (int i = 1; i < this.getNbSchtroumpf(); i++) {
			if (this.peuple.get(i).getAge() > chef.getAge())
				chef = this.peuple.get(i);
		}
		return chef;
	}
	
	/** Envoit un Schtroumpf sur deux au travail
	 * Les rend mécontent
	 */
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
	
	/** Fait se présenter tout les Schtroumpf content
	 */
	public void schtroumpsfHeureux () {
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			if (this.peuple.get(i).estContent())
				this.peuple.get(i).sePresenter();
		}
	}
	
	/** Fait dîner tous les Schtroumpf
	 * Chaque Schtroumpf prend 3 feuilles
	 */
	public void dinerTousEnsemble() {
		for (int i = 0; i < this.getNbSchtroumpf(); i++) {
			this.peuple.get(i).dinerAuVillage();
		}
	}
	
	/** Fait ceuillir un Schtroumpf content sur deux
	 * Chaque Schtroumpf ramasse 5 feuilles
	 */
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
	
	/** Augmente ou diminue le stock du village
	 * @param pfQte IN : nombre entier relatif à ajouter au stock
	 */
	public void changerStock(int pfQte) {
		this.stock += pfQte;
	}
}
