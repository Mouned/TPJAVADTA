package utils;

import java.util.ArrayList;

import form.*;
import interfaceUtils.Surfacable;

public class FigureUtil {

	private final static int valueX = 100;
	private final static int valueY = 100;
	private final static int valueSeg = 50;
	private final static int rand = 12;

	public static Figure getRandomFigure() {

		double valueRand = Math.random()*rand;

		if(valueRand > 0 && valueRand < 3)
			return getRandomRond();
		else if(valueRand >= 3 && valueRand < 6)
			return getRandomRectangle();
		else if(valueRand >= 6 && valueRand < 9)
			return getRandomCarre();
		else
			return getRandomSegment();
	}

	public static Surfacable getRandomSurfacable() {

		double valueRand = Math.random()*rand;

		if(valueRand > 0 && valueRand < 4)
			return getRandomRond();
		else if(valueRand >= 4 && valueRand < 7)
			return getRandomRectangle();
		else 
			return getRandomCarre();
	}

	public static Rond getRandomRond() {
		return new Rond(getRandomPoint(), getRandomValueLong());
	}

	public static Rectangle getRandomRectangle() {
		return new Rectangle(getRandomPoint(),getRandomValueLong(),getRandomValueLarg());
	}

	public static Carre getRandomCarre() {
		Carre c = new Carre(getRandomPoint(),getRandomValueLong());
		return c;
	}

	public static Segment getRandomSegment() {
		double rand = Math.random();

		if(rand > 0.5)
			return new Segment(getRandomPoint(),getRandomValueLong(),true);
		else
			return new Segment(getRandomPoint(),getRandomValueLong(),false);
	}

	private static Point getRandomPoint() {
		Point randomPoint;

		int valX = getRandomValueX();
		int valY = getRandomValueY();
		randomPoint = new Point(valX, valY);
		return randomPoint;
	}

	private static int getRandomValueX() {
		return (int) (Math.random()*valueX);
	}

	private static int getRandomValueY() {
		return (int) (Math.random()*valueY);
	}

	private static int getRandomValueLong() {
		return (int) (Math.random()*valueSeg);
	}

	private static int getRandomValueLarg() {
		return (int) (Math.random()*valueSeg);
	}

	public static ArrayList<Point> getPoints(Figure...figures) {

		ArrayList<Point> list_Points = new ArrayList<>();
		//		int cpt_Points = 0;
		//		int index = 0;
		//		for(Figure f : figures) {
		//			cpt_Points += f.getPoints().size();
		//		}
		//		
		//		tab_Points = new Point[cpt_Points];

		for(Figure f : figures) {
			for(Point p : f.getPoints()) {
				//	tab_Points[index] = p;
				list_Points.add(p);
				//	index++;
			}
		}

		return list_Points;
		//return tab_Points;
	}

	public static String toStringTabPoints(ArrayList<Point> tab_Points) {
		String s="[";
		for(Point p : tab_Points)
			s+=p.toString();

		return s+"]";
	}

	public static ArrayList<Figure> genere(int nb_Figure){
		ArrayList<Figure> list_figure = new ArrayList<>();

		for(int index = 0; index < nb_Figure ; index++)
			list_figure.add(getRandomFigure());

		return list_figure;
	}

}
