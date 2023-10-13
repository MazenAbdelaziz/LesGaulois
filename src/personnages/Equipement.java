//package personnages;
//
//public enum Equipement {
//	CASQUE("casque"), BOUCLIER("bouclier");
//
//	private String nom;
//
//	private Equipement(String nom) {
//		this.nom = nom;
//	}
//
//	public String getNom() {
//		return nom;
//	}
//
//	@Override
//	public String toString() {
//		return nom;
//	}
//}
package personnages;

public enum Equipement {

	CASQUE("casque"), BOUCLIER("bouclier");

	private String nom;

	private Equipement(String nom) {
		this.nom = nom;

	}

	@Override
	public String toString() {
		return nom;
	}

	String getNom() {
		return nom;
	}

}