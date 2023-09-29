package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois = 0;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Le village est plein, impossible d'ajouter plus de villageois.");
		}
	}

	public Gaulois trouverHabitant(int numero) {
		if (numero >= 0 && numero < nbVillageois) {
			return villageois[numero];
		} else {
			System.out.println("Aucun villageois trouvé avec le numéro " + numero);
			return null;
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);

		// Gaulois gaulois = village.trouverHabitant(30);
		// "ArrayIndexOutOfBoundsException" car le tableau villageois va de 0 à 29, pas
		// jusqu'à 30.

		Chef abraracourcix = new Chef("Abraracourcix", 6);
		village.setChef(abraracourcix);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);

		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		// (Astérix, avec l'indice 0) dans le village et le numéro 1 ne correspond à
		// aucun villageois.

		Gaulois obelix = new Gaulois("Obélix", 25); // Création d'Obélix avec une force de 25
		village.ajouterHabitant(obelix); // Ajout d'Obélix au village

		// Appel de la méthode pour afficher tous les villageois
		village.afficherVillageois();
	}

	public void afficherVillageois() {
		if (chef != null) {
			System.out.println("Chef du village: " + chef.getNom() + ", Force: " + chef.getForce());
		} else {
			System.out.println("Le village n'a pas de chef.");
		}

		System.out.println("Villageois:");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i].getNom() + ", Force: " + villageois[i].getForce());
		}
	}
}
