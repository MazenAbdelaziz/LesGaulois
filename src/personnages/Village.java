package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	private int nbVillageoisMax;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.nbVillageoisMax = nbVillageoisMax;
		this.villageois = new Gaulois[nbVillageoisMax];
		this.nbVillageois = 0;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMax) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Nombre de villageois max atteint.");
		}
	}

	public Gaulois trouverHabitant(int numVillageois) {
		if (numVillageois >= 0 && numVillageois < nbVillageois) {
			return villageois[numVillageois];
		} else {
			System.out.println("Le numéro n'est pas correct.");
			return null;
		}
	}

	public void afficherVillageois() {
		if (chef != null) {
			System.out.println("Chef : " + chef.getNom());
		} else {
			System.out.println("Pas de chef dans le village.");
		}

		if (nbVillageois > 0) {
			System.out.println("Villageois :");
			for (int i = 0; i < nbVillageois; i++) {
				System.out.println(villageois[i].getNom());
			}
		} else {
			System.out.println("Aucun villageois dans le village.");
		}
	}

// Classe VillageMain
//public class VillageMain {
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		Chef Abraracourcix = new Chef("Abraracourcix", 6);
		village.setChef(Abraracourcix);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);

		// Appeler la méthode afficherVillageois pour vérifier
		village.afficherVillageois();
	}
}