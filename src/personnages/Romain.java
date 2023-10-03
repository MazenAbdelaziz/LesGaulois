package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		if (force < 0) {
			throw new IllegalArgumentException("La force d'un Romain doit être positive.");
		}
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//
//		assert force >= 0 : "La force d'un Romain doit être positive avant de recevoir un coup.";
//
//		force -= forceCoup;
//
//		assert force <= (force + forceCoup) : "La force d'un Romain n'a pas diminué après avoir reçu un coup.";
//
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//	}

//////////////////////////////////////////TP 3 /////////////////////////////////////////////////////////

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;

		forceCoup = CalculResistanceEquipement(forceCoup);

		force -= forceCoup;

		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}

		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

/////////////////////////////////////////////////////TP 3 ////////////////////////////////////////////////////////
	public void ajouterEquipement(Equipement equipement) {
		if (nbEquipement < equipements.length) {
			equipements[nbEquipement] = equipement;
			nbEquipement++;
		} else {
			System.out.println("Nombre maximum d'équipements atteint.");
		}
	}

	public void afficherEquipements() {
		System.out.print("Équipements de " + nom + ": ");
		for (int i = 0; i < nbEquipement; i++) {
			System.out.print(equipements[i].getNom() + " ");
		}
		System.out.println();
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
			break;
		case 1:
			if (possedeEquipement(equipement)) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
			} else {
				ajouterEquipement(equipement);
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		default:
			System.out.println("Erreur : nombre d'équipements invalide.");
		}
	}

	private boolean possedeEquipement(Equipement equipement) {
		return equipements[0] == equipement;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		System.out.println(asterix.getNom());
		System.out.println(asterix);

		// Tests
		minus.prendreParole();
		minus.parler(null);
		minus.recevoirCoup(10);

		// Tester l'énumération Equipement
		Equipement monEquipement = Equipement.CASQUE;
		System.out.println("Mon équipement : " + monEquipement);
		Equipement autreEquipement = Equipement.BOUCLIER;
		System.out.println("Autre équipement : " + autreEquipement);

		// Tester la méthode sEquiper
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}