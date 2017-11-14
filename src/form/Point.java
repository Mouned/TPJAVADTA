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

	public boolean isEqualPoint(Point otherPoint) {
		return ( getAbscisse()==otherPoint.getAbscisse() && getOrdonnee()==otherPoint.getOrdonnee() ); 
	}

}
