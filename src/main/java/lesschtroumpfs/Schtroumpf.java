package lesschtroumpfs;

/**
 * Classe définissant le type Schtroumpf
 * @author Guibert Rémy
 */
public class Schtroumpf {
	private String nom;
	private int age;
	private boolean content;
	private Village village;

	/** Constructeur à deux arguments
	 * Asigne au Schtroumpf un nom et un âge
	 * @param nom IN : nom du Schtroumpf
	 * @param age IN : âge du Schtroumpf
	 */
	public Schtroumpf (String nom, int age) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = null;
	}

	/** Constructeur à trois arguments
	 * Asigne au Schtroumpf un nom, un âge et un village
	 * @param nom IN : nom du Schtroumpf
	 * @param age IN : âge du Schtroumpf
	 * @param village IN : village auquel est rataché le Schtroumpf
	 */
	public Schtroumpf (String nom, int age, Village village) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = village;
	}

	/** Renvoit le nom du Schtroumpf
	 * @return nom du Schtroumpf
	 */
	public String getNom() {
		return this.nom;
	}

	/** Renvoit l'âge du Schtroumpf
	 * @return âge du Schtroumpf
	 */
	public int getAge() {
		return this.age;
	}

	/** Renvoit l'état du Schtroumpf
	 * @return vrai si le Schtroumpf est content
	 */
	public boolean estContent() {
		return this.content;
	}
	
	/** Renvoit la présentation du Schtroumpf
	 * @return la présentation du Schtroumpf
	 */
	public String toString() {
		if (this.content) {
			if (this.village == null)
				return "Je suis "+this.nom+", j'ai "+this.age+" ans et je suis content et ermite";
			else
				return "Je suis "+this.nom+", j'ai "+this.age+" ans et je suis content et j'habite a "+this.getVillage().getNom();
		}
		else {
			if (this.village == null)
				return "Je suis "+this.nom+", j'ai "+this.age+" ans et je suis PAS content et ermite";
			else
				return "Je suis "+this.nom+", j'ai "+this.age+" ans et je suis PAS content et j'habite a "+this.getVillage().getNom();
		}
	}
	
	/** Affiche la présentation du Schtroumpf
	 */
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	/** Renvoit le chant du Schtroumpf
	 * @return le chant du Schtroumpf
	 */
	public String leChant() {
		if (this.content)
			return "la, la, la Schtroumpf la, la";
		else
			return "gloups";
	}
	
	/** Affiche le chant du Schtroumpf
	 */
	public void chanter() {
		System.out.println(this.leChant());
	}

	/** Fête l'anniversaire d'un Schtroumpf
	 * Augmente l'âge du Schtroumpf de 1
	 */
	public void anniversaire() {
		this.age ++;
	}

	/** Fait manger le Schtroumpf
	 * Le rend content car il a droit a son plat préféré
	 * @param pfQte IN : quantité à manger
	 */
	public void manger(int pfQte) {
		if (pfQte > 0)
			this.content = true;
	}

	/** Fait travailler le Schtroumpf
	 * Le rend mécontent car son job consiste à se p********* et il n'aime guère ça
	 */
	public void allerTravailler() {
		this.content = false;
	}

	/** Renvoit le village auquel appartient le Schtroumpf
	 * @return l'adresse mémoire du Schtroumpf
	 */
	public Village getVillage() {
		return this.village;
	}
	
	/** Défini le village du Schtroumpf
	 * @param pfV IN : l'adresse mémoire du village
	 */
	public void setVillage(Village pfV) {
		this.village = pfV;
	}

	/** Fait récolter de la salsepareille au Schtroumpf
	 * Il la mange directement s'il est ermite
	 * sinon augmente le stock du village de 5
	 */
	public void recolterSalsepareille() {
		this.allerTravailler();
		if (this.village == null)
			this.manger(5);
		else
			this.village.changerStock(5);
	}
	
	/** Fait manger le Schtroumpf au village
	 * Si il est ermite, il ne pourra pas manger au village alors il devient mécontent
	 * Sinon il mange trois feuilles et devient content
	 */
	public void dinerAuVillage() {
		if (this.village == null)
			this.content = false;
		else {
			if (this.village.getStockSalsepareille() > 3) {
				this.manger(3);
				this.village.changerStock(-3);
			}
		}
	}
}
