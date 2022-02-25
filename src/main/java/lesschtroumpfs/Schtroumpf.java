package lesschtroumpfs;

public class Schtroumpf {
	private String nom;
	private int age;
	private boolean content;
	private Village village;


	public Schtroumpf (String nom, int age) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = null;
	}

	public Schtroumpf (String nom, int age, Village village) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = village;
	}


	public String getNom() {
		return this.nom;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public boolean estContent() {
		return this.content;
	}
	
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
	
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	public String leChant() {
		if (this.content)
			return "la, la, la Schtroumpf la, la";
		else
			return "gloups";
	}
	
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	public void anniversaire() {
		this.age ++;
	}
	
	public void manger(int pfQte) {
		if (pfQte > 0)
			this.content = true;
	}

	public void allerTravailler() {
		this.content = false;
	}
	
	public Village getVillage() {
		return this.village;
	}
	
	public void setVillage(Village pfV) {
		this.village = pfV;
	}
	
	public void recolterSalsepareille() {
		this.allerTravailler();
		if (this.village == null)
			this.manger(5);
		else
			this.village.changerStock(5);
	}
	
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
