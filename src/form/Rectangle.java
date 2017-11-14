package form;

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

	public String getType() {
		return "RECT";
	}
	
	public void affiche() {
		System.out.println(toString());
	}

	@Override
	public double surface() {
		return longueur*largeur;
	}

	@Override
	public Point[] getPoints() {
		Point[] tab_points = new Point[4];
		tab_points[0] = getPointBasGauche();
		tab_points[1] = getPointBasDroite();
		tab_points[2] = getPointHautDroite();
		tab_points[3] = getPointHautGauche();
		return tab_points;
	}
}
