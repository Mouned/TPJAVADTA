package form;

import java.util.ArrayList;

public abstract class Figure {

	public abstract Point getCentre();
	
	public void affiche() {
		System.out.println(toString());
	}

	public abstract ArrayList<Point> getPoints();
	
	public abstract boolean couvre(Point p);
}
