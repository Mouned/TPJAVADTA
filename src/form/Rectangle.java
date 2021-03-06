package form;

import java.util.ArrayList;

import couleur.Couleur;
import exception.PointInvalideCoordException;
import interfaceUtils.Surfacable;

public class Rectangle extends Figure implements Surfacable{


	private Point pointBasGauche;
	private int longueur;
	private int largeur;

	public Rectangle(Point p, int lon, int lag, Couleur c) throws PointInvalideCoordException {
		super(c);
		pointBasGauche = p;
		longueur = lon;
		largeur = lag;
	}

	public Rectangle(Point p, int lon, int lag) throws PointInvalideCoordException {
		this(p,lon,lag,Couleur.getCouleurDefaut());
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

	public Point getPointBasDroite() throws PointInvalideCoordException {
		return new Point(pointBasGauche.getAbscisse()+longueur,pointBasGauche.getOrdonnee());
	}

	public Point getPointHautGauche() throws PointInvalideCoordException {
		return new Point(pointBasGauche.getAbscisse(),pointBasGauche.getOrdonnee()+largeur);
	}

	public Point getPointHautDroite() throws PointInvalideCoordException {
		return new Point(pointBasGauche.getAbscisse()+longueur,pointBasGauche.getOrdonnee()+largeur);
	}

	public String toString() {
		try {
			return "["+getType() +" "+getPointBasGauche().toString()
					+getPointBasDroite().toString()+""
					+getPointHautGauche().toString()+""
					+getPointHautDroite().toString()+" ; "
					+getCouleur()+"]";
		}catch (PointInvalideCoordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
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
		try {
			list_points.add(getPointBasGauche());
			list_points.add(getPointBasDroite());
			list_points.add(getPointHautDroite());
			list_points.add(getPointHautGauche());

		} catch(PointInvalideCoordException e) {
			e.printStackTrace();
		}

		return list_points;
	}

	@Override
	public boolean couvre(Point p) {
		// P est dans le rectangle/carre si ses coordonnees sont comprises dans celles des extremites du rectangle/carre

		try  {
			boolean supPointBasGauche = p.getAbscisse() >= getPointBasGauche().getAbscisse()
					&&  p.getOrdonnee() >= getPointBasGauche().getOrdonnee();

					boolean infPointHautDroite = p.getAbscisse() <= getPointHautDroite().getAbscisse()
							&&   p.getOrdonnee() <= getPointHautDroite().getOrdonnee();

					return supPointBasGauche && infPointHautDroite;
		}catch(PointInvalideCoordException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean equals(Object obj) {
		if(obj instanceof Rectangle || obj instanceof Carre) {
			Rectangle otherRectangle = (Rectangle) obj;
			return getPointBasGauche().equals(otherRectangle.getPointBasGauche())
					&& getLongueur() == otherRectangle.getLongueur()
					&& getLargeur() == otherRectangle.getLargeur();
		}
		return false;
	}

	@Override
	public Point getCentre() {
		Segment diagonale;
		try {
			diagonale = new Segment(getPointBasGauche(), getPointHautDroite());
			return diagonale.getCentre();
		} catch (PointInvalideCoordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double distanceOrigine(Point p) {
		double distanceMin = Double.MAX_VALUE;
		double distance_Curr = 0.0;

		for(Point rect_point : getPoints())
			if((distance_Curr = rect_point.distance(p)) < distanceMin)
				distanceMin = distance_Curr;

		return distanceMin;
	}

}
