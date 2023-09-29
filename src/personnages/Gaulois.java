package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPostion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force / 3 * effetPostion);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPostion=" + effetPostion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 10);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
//		asterix.prendreParole();
//		asterix.parler(null);
//		asterix.frapper(minus);
		asterix.boirePotion(4);
	}

	public void boirePotion(int forcePotion) {
		int effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}

	public int getForce() {
		return force;
	}

}
