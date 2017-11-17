package form;

import couleur.Couleur;
import interfaceUtils.Surfacable;

public class Carre extends Rectangle implements Surfacable{

	public Carre(Point pointBasGauche, int cote, Couleur c) {
		super(pointBasGauche,cote,cote,c);
	}

	protected String getType() {
		return "CARRE";
	}
}
