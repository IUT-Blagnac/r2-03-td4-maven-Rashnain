import lesschtroumpfs.Village;
import lesschtroumpfs.Schtroumpf;

public class MainVillage {

	public static void main (String[] argv) {
		String[] nomsSchtroumpfs = {
		        "Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)", "Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur a lunettes",
		        "Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf etonne", "Schtroumpf acrobate", "Schtroumpf paresseux"
		};
		
		Village village = new Village("Village des bleus", 500, nomsSchtroumpfs);
		
		village.solstice_d_ete();
		
		Schtroumpf chef = village.chefDuVillage();
		chef.sePresenter();
		
		village.envoyerAuTravail();
		
		village.schtroumpsfHeureux();
		
		village.envoyerCueillirSalsepareille();
		
		village.solstice_d_ete();
		
		village.dinerTousEnsemble();
		
		village.solstice_d_ete();
	}

}
