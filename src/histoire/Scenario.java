package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {
	public static void main(String[] args) {

		Druide panoramix = new Druide("Panoramix", 5, 10);

		panoramix.parler("Bonjour, je suis le druide " + panoramix.getNom() + " et ma potion peut aller d'une force "
				+ panoramix.getEffetPotionMin() + " à " + panoramix.getEffetPotionMax() + ".");
		panoramix.parler("Je vais aller préparer une petite potion...");

		panoramix.preparerPotion();

		Gaulois obelix = new Gaulois("Obélix", 25);
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");

		Gaulois asterix = new Gaulois("Astérix", 8);
		panoramix.booster(asterix);

		asterix.parler("Bonjour");

		Romain minus = new Romain("Minus", 6);

		minus.parler("UN GAU... UN GAUGAU...");

		asterix.frapper(minus);

		minus.parler("J'abandonne...");
	}
}
