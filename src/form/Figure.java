package form;

import java.util.ArrayList;

import couleur.Couleur;

public abstract class Figure implements Comparable<Figure>{

	protected Point org = new Point(0,0);

	protected static int cpt = 0;
	protected int id = cpt++;
	private Couleur couleur;

	protected Figure() {

	}

	protected Figure(Couleur c) {
		couleur = c; 
	}

	public abstract Point getCentre();

	public int getId() {
		return id;
	}

	public void affiche() {
		System.out.println(toString());
	}

	public abstract ArrayList<Point> getPoints();

	public abstract boolean couvre(Point p);

	public abstract boolean equals(Object o);

	public abstract double distanceOrigine(Point p);

	public int compareTo(Figure o) {
		if(o.distanceOrigine(org) > distanceOrigine(org))
			return 1;
		else if(o.distanceOrigine(org) < distanceOrigine(org))
			return -1;
		else 
			return 0;		
	}

	public Couleur getCouleur() {
		return couleur;
	}
}
