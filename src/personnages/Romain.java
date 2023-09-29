package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		if (force < 0) {
			throw new IllegalArgumentException("La force d'un Romain doit être positive.");
		}
		this.force = force;
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

	public void recevoirCoup(int forceCoup) {

		assert force >= 0 : "La force d'un Romain doit être positive avant de recevoir un coup.";

		force -= forceCoup;

		assert force <= (force + forceCoup) : "La force d'un Romain n'a pas diminué après avoir reçu un coup.";

		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
//		minus.prendreParole();
//		minus.parler(null);
//		minus.recevoirCoup(10);
	}
}
