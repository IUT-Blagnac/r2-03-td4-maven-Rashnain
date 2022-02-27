package test;

import lesschtroumpfs.Village;
import lesschtroumpfs.Schtroumpf;

/**
 * Classe testant le type Village
 * @author Guibert Rémy
 */
public class MainVillage {

	/** Fonction principale
	* Créer un Village et test la classe Village
	* @param argv IN : argument de ligne de commandes (inutilisés)
	*/
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
