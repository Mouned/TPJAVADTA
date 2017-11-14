package form;

import java.util.ArrayList;

public abstract class Figure {

	public abstract void affiche();

	public abstract ArrayList<Point> getPoints();
	
	public abstract boolean couvre(Point p);
}
