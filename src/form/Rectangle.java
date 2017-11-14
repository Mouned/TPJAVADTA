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

	public void affiche() {
		System.out.println(toString());
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
		// TODO Auto-generated method stub
		return false;
	}
}
