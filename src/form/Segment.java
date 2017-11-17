package form;

import java.util.ArrayList;

public class Segment extends Figure{


	private Point debut;
	private Point fin;
	private int longueur;
	private boolean horizontal;


	public Segment(Point p, int lon, boolean horiz) {
		debut = p;
		longueur=lon;
		horizontal=horiz;
		fin = new Point(p.getAbscisse() + (horizontal?longueur:0),p.getOrdonnee() + (horizontal?0:longueur));
		id = cpt;
		cpt++;	
	}

	public Segment(Point p1, Point p2) {
		debut = p1;
		fin = p2;
		longueur = (int)(Math.round(p1.distance(p2)));
	}

	public Point getDebut() {
		return debut;
	}

	public Point getFin() {
		return fin;
	}

	public int getLongueur() {
		return longueur;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	@Override
	public String toString() {
		return "[SEG "+debut.toString()+" à "+fin.toString()+"]";
	}

	@Override
	public ArrayList<Point> getPoints() {
		//		Point[] tab_points = new Point[2];
		//		tab_points[0] = getDebut();
		//		tab_points[1] = getFin();
		ArrayList<Point> list_points = new ArrayList<>();
		list_points.add(getDebut());
		list_points.add(getFin());
		return list_points;
	}

	@Override
	public boolean couvre(Point p) {
		if(isHorizontal()) {
			if(debut.getAbscisse() > fin.getAbscisse()) {
				if(p.getAbscisse() <= debut.getAbscisse() && p.getAbscisse() >= fin.getAbscisse()) {
					return p.getOrdonnee() == debut.getOrdonnee();
				}
			}
			if(debut.getAbscisse() < fin.getAbscisse()) {
				if(p.getAbscisse() >= debut.getAbscisse() && p.getAbscisse() <= fin.getAbscisse()) {
					return p.getOrdonnee() == debut.getOrdonnee();
				}
			}
		}

		if(!isHorizontal()) {
			if(debut.getOrdonnee() > fin.getOrdonnee()) {
				if(p.getOrdonnee() <= debut.getOrdonnee() && p.getOrdonnee() >= fin.getOrdonnee()) {
					return p.getAbscisse() == debut.getAbscisse();
				}
			}
			if(debut.getOrdonnee() < fin.getOrdonnee()) {
				if(p.getOrdonnee() >= debut.getOrdonnee() && p.getOrdonnee() <= fin.getOrdonnee()) {
					return p.getAbscisse() == debut.getAbscisse();
				}
			}
		}
		return false;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Segment) {
			Segment otherSegment = (Segment) obj;
			return getDebut().equals(otherSegment.getDebut())
					&& getFin().equals(otherSegment.getFin());
		}
		return false;
	}

	public Point getCentre() {
		return new Point( (getDebut().getAbscisse() + getFin().getAbscisse()) / 2 , 
				(getDebut().getOrdonnee() + getFin().getOrdonnee()) / 2);
	}

	@Override
	public double distanceOrigine(Point p) {
		return (debut.distance(p) > fin.distance(p) ? debut.distance(p) : fin.distance(p) );
	}

}
