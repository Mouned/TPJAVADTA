package form;

import java.util.ArrayList;

import interfaceUtils.Surfacable;

public class Rectangle extends Figure implements Surfacable {


	private Point pointBasGauche;
	private int longueur;
	private int largeur;

	public Rectangle(Point p, int lon, int lag) {
		pointBasGauche = p;
		longueur = lon;
		largeur = lag;
	}

	public int getLongueur() {
		return longueur;
	}


	public int getLargeur() {
		return largeur;
	}


	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public Point getPointBasDroite() {
		return new Point(pointBasGauche.getAbscisse()+longueur,pointBasGauche.getOrdonnee());
	}

	public Point getPointHautGauche() {
		return new Point(pointBasGauche.getAbscisse(),pointBasGauche.getOrdonnee()+largeur);
	}

	public Point getPointHautDroite() {
		return new Point(pointBasGauche.getAbscisse()+longueur,pointBasGauche.getOrdonnee()+largeur);
	}

	public String toString() {
		return "["+getType() +" "+getPointBasGauche().toString()
				+getPointBasDroite().toString()+""
				+getPointHautGauche().toString()+""
				+getPointHautDroite().toString();
	}

	protected String getType() {
		return "RECT";
	}

	@Override
	public double surface() {
		return longueur*largeur;
	}

	@Override
	public ArrayList<Point> getPoints() {
		ArrayList<Point> list_points = new ArrayList<>();
		list_points.add(getPointBasGauche());
		list_points.add(getPointBasDroite());
		list_points.add(getPointHautDroite());
		list_points.add(getPointHautGauche());
		return list_points;
	}

	@Override
	public boolean couvre(Point p) {
		// P est dans le rectangle/carre si ses coordonnees sont comprises dans celles des extremites du rectangle/carre
		boolean supPointBasGauche = p.getAbscisse() >= getPointBasGauche().getAbscisse()
				&&  p.getOrdonnee() >= getPointBasGauche().getOrdonnee();

				boolean infPointHautDroite = p.getAbscisse() <= getPointHautDroite().getAbscisse()
						&&   p.getOrdonnee() <= getPointHautDroite().getOrdonnee();

				return supPointBasGauche && infPointHautDroite;
	}


	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle otherRectangle = (Rectangle) obj;
			return getPointBasGauche().equals(otherRectangle.getPointBasGauche())
					&& getLongueur() == otherRectangle.getLongueur()
					&& getLargeur() == otherRectangle.getLargeur();
		}
		return false;
	}

	@Override
	public Point getCentre() {
		// TODO Auto-generated method stub
		return null;
	}
}
