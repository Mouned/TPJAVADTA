package form;


public class Point {

	private int abscisse;
	private int ordonnee;

	private final static int INIT_X = 25;
	private final static int INIT_Y = 25;


	public Point(int x, int y) {
		abscisse = x;
		ordonnee = y;
	}

	public Point() {
		this(INIT_X,INIT_Y);
	}


	public int getAbscisse() {
		return abscisse;
	}


	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}


	public int getOrdonnee() {
		return ordonnee;
	}


	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	public void deplace(int deltaAbs, int deltaOrd) {
		setAbscisse(getAbscisse()+deltaAbs);
		setOrdonnee(getOrdonnee()+deltaOrd);
	}

	public String toString() {
		return "["+getAbscisse()+";"+getOrdonnee()+"]";
	}

	public boolean equals(Object obj) {

		if(obj instanceof Point) {
			Point otherPoint = (Point) obj;
			return ( getAbscisse()==otherPoint.getAbscisse() && getOrdonnee()==otherPoint.getOrdonnee() ); 
		}

		return false;
	}

	public double distance(Point otherPoint) {
		return Math.sqrt( Math.pow(otherPoint.getAbscisse()-getAbscisse(), 2) + Math.pow(otherPoint.getOrdonnee()-getOrdonnee(), 2) );
	}

	public int compareto(Point p) {
		Point org = new Point(0,0);
		if(p.distance(org) > distance(org))
			return 1;
		if(p.distance(org) < distance(org))
			return -1;
		return 0;
	}

}
