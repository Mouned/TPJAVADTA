package form;

import java.util.ArrayList;

public abstract class Figure implements Comparable<Figure>{

	protected Point org = new Point(0,0);
	
	public abstract Point getCentre();
	
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
}
