package form;

import interfaceUtils.Surfacable;

public class Rond extends Figure implements Surfacable {

	
	private Point centre;
	private int rayon;
	
	public Rond(Point p, int r) {
		centre = p;
		rayon = r;
	}
	
	public Point getCentre() {
		return centre;
	}



	public int getRayon() {
		return rayon;
	}



	public String toString() {
		return "[Rond "+centre.toString()+", "+rayon+"]";
	}
	
	public void affiche() {
		System.out.println(toString());
	}

	@Override
	public double surface() {
		return (Math.PI)*(Math.pow(rayon, 2));
	}

	@Override
	public Point[] getPoints() {
		Point[] tab_points = new Point[1];
		tab_points[0] = getCentre();
		return tab_points;
	}
}
