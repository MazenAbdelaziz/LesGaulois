package personnages;

public class Musee {
	private String[][] trophees; // Tableau pour stocker les trophées (chaque élément contient le nom du Gaulois
									// et l'équipement)
	private int nbTrophees; // Compteur pour le nombre de trophées contenus dans le musée

	public Musee() {
		trophees = new String[200][2]; // Crée un tableau de 200 emplacements pour les trophées
		nbTrophees = 0; // Initialise le compteur de trophées à 0
	}

	public void donnerTrophee(String gaulois, String equipement) {
		if (nbTrophees < 200) {
			trophees[nbTrophees][0] = gaulois; // Ajoute le nom du Gaulois
			trophees[nbTrophees][1] = equipement; // Ajoute l'équipement
			nbTrophees++; // Incrémente le compteur de trophées
			System.out.println(gaulois + " a fait don de " + equipement + " au musée.");
		} else {
			System.out.println("Le musée est plein, nous ne pouvons pas accepter plus de trophées.");
		}
	}

	public static void main(String[] args) {
		Musee musee = new Musee();
		musee.donnerTrophee("Abrar", "Casque en or");
		musee.donnerTrophee("Julia", "Épée en argent");
	}
}
