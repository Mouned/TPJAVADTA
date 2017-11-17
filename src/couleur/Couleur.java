package couleur;

public enum Couleur {
	Rouge("R"), Vert("V"), Bleu("B"), Jaune("J"), Noir("N");

	private String name = "";

	Couleur(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public static Couleur getCouleurDefaut() {
		return Noir;
	}
}
