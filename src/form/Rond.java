package form;

import java.util.ArrayList;

import interfaceUtils.Surfacable;

public class Rond extends Figure implements Surfacable{


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
		return Math.round(getCentre().distance(p)) <= getRayon();
	}


	public boolean equals(Object obj) {
		if(obj instanceof Rond) {
			Rond otherRond = (Rond) obj;
			return otherRond.getCentre().equals(getCentre()) 
					&& otherRond.getRayon() == getRayon();
		}
		return false;
	}

	@Override
	public double distanceOrigine(Point p) {
		return getCentre().distance(p);
	}

//	@Override
//	public int compareTo(Figure o) {
//		// Comparaison de cercle 
//		if(o instanceof Rond) {
//			Rond rnd = (Rond) o;
//			// si leur centre sont confondus
//			if(rnd.getCentre().equals(getCentre())) {
//				// on compare le rayon
//				if(rnd.getRayon() > getRayon()) // si o.rayon > this.rayon
//					return -1; // -1
//				else if(rnd.getRayon() < getRayon()) // si o.rayon < this.rayon
//					return 1; // 1
//				else 
//					return 0; // sinon 0, les deux cercles sont confondus
//			}else {
//				// si leur centre ne sont pas confondus, on compare l'abscisse et l'ordonnée des centres des cercles
//				// si le cercle o est à gauche ou/et au dessus de this
//				if(rnd.getCentre().getAbscisse() > getCentre().getAbscisse() 
//						|| rnd.getCentre().getOrdonnee() > getCentre().getOrdonnee() ) {
//					return -1; // -1
//				}
//				// si le cercle o est en dessous ou/et en dessous de this 
//				else if(rnd.getCentre().getAbscisse() <= getCentre().getAbscisse()
//						|| rnd.getCentre().getOrdonnee() <= getCentre().getOrdonnee() ) {
//					return 1;
//				}
//			}
//		}
//		return -1;
//	}
}
