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

	public int getNbVillageois() {
		return nbVillageois;
	}

	public void ajouterHabitant(Gaulois villageois) {
		if (nbVillageois < this.villageois.length) {
			this.villageois[nbVillageois] = villageois;
			nbVillageois++;
		} else {
			System.out.println("Le village est plein, impossible d'ajouter plus de villageois.");
		}
	}

	public Gaulois trouverHabitant(int numero) {
		if (numero >= 0 && numero < nbVillageois) {
			return villageois[numero];
		} else {
			System.out.println("Le numéro de villageois n'est pas valide.");
			return null;
		}
	}

}
