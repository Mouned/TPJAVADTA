package form;

import interfaceUtils.Surfacable;

public class Carre extends Rectangle implements Surfacable{


	public Carre(Point pointBasGauche, int cote) {
		super(pointBasGauche,cote,cote);
	}

	public String getType() {
		return "CARRE";
	}
}
