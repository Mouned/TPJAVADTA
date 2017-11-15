package form;

import java.util.ArrayList;

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
	public ArrayList<Point> getPoints() {
		//		Point[] tab_points = new Point[1];
		//		tab_points[0] = getCentre();
		ArrayList<Point> list_points = new ArrayList<>();
		list_points.add(getCentre());
		return list_points;
	}

	@Override
	public boolean couvre(Point p) {
		// Comparaison de la distance entre les deux points et le rayon du cercle
		System.out.println(getCentre().distance(p));
		return Math.round(getCentre().distance(p)) <= getRayon();
	}
}
