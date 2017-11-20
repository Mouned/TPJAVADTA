package form;

import couleur.Couleur;
import exception.PointInvalideCoordException;
import interfaceUtils.Surfacable;

public class Carre extends Rectangle implements Surfacable{

	public Carre(Point pointBasGauche, int cote, Couleur c) throws PointInvalideCoordException {
		super(pointBasGauche,cote,cote,c);
	}

	protected String getType() {
		return "CARRE";
	}
}
