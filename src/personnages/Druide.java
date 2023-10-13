//package personnages;
//
//import java.util.Random;
//
//public class Druide {
//	private String nom;
//	private int effetPotionMin;
//	private int effetPotionMax;
//	private int forcePotion;
//
//	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
//		this.nom = nom;
//		this.effetPotionMin = effetPotionMin;
//		this.effetPotionMax = effetPotionMax;
//		this.forcePotion = 1;
//		parler("Bonjour, je suis le druide " + nom + "et ma potion peut aller d'une force " + effetPotionMin + " a "
//				+ effetPotionMax + ".");
//	}
//
//	public String getNom() {
//		return nom;
//	}
//
//	public void parler(String texte) {
//		System.out.println(prendreParole() + "«" + texte + "»");
//	}
//
//	private String prendreParole() {
//		return "Le druide " + nom + " : ";
//	}
//
//	public void preparerPotion() {
//		Random random = new Random();
//		forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
//
//		if (forcePotion > 7) {
//			parler("J'ai préparé une super potion de force " + forcePotion + ".");
//		} else {
//			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion + ".");
//		}
//	}
//
//	private int getForcePotion() {
//		return 0;
//	}
//
//	public static void main(String[] args) {
//		Druide panoramix = new Druide("Panoramix", 5, 10);
//
//		for (int i = 0; i < 5; i++) {
//			panoramix.preparerPotion();
//			int forcePotion = panoramix.getForcePotion();
//			System.out.println("Force de la potion préparée : " + forcePotion);
//		}
//	}
//
//	public void booster(Gaulois gaulois) {
//		if (gaulois.getNom().equals("Obélix")) {
//			System.out.println("Le druide " + nom + " : Non, Obélix !... Tu n'auras pas de potion magique !");
//		} else {
//			gaulois.boirePotion(getForcePotion());
//		}
//	}
//
//	public int getEffetPotionMax() {
//		return effetPotionMax;
//	}
//
//	public int getEffetPotionMin() {
//		return effetPotionMin;
//	}
//
//}
package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	// private Random random = SecureRandom.getInstanceStrong();
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMin, effetPotionMax);

		if (forcePotion > effetPotionMax && forcePotion < effetPotionMin) {
			parler("j'ai preparé une super potion de force " + forcePotion + ".");
		} else {
			parler("je n'ai pas trouvé tous les ingredients, ma potion est seulement de force" + forcePotion + ".");
		}
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() != null && gaulois.getNom().equals("Obélix")) {
			parler("Non ,Obélix !... tu n'auras pas de potion magique");
		} else {
			gaulois.boirePotion(forcePotion);
		}

	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("panoramix", 5, 10);
		panoramix.preparerPotion();

	}

}