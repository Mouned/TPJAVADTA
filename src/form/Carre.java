package form;

import interfaceUtils.Surfacable;

public class Carre extends Rectangle implements Surfacable{

	private Point pointBasGauche;
	private int cote;
	
	
	public Carre(Point pointBasGauche, int cote) {
		super(pointBasGauche,cote,cote);
	}
	
	public String getType() {
		return "CARRE";
	}
}
