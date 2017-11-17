package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import form.Carre;
import form.Figure;
import form.Point;
import form.Rectangle;
import form.Rond;
import form.Segment;
import interfaceUtils.Surfacable;

public class FigureUtil {

	private final static int valueX = 100;
	private final static int valueY = 100;
	private final static int valueSeg = 50;
	private final static int rand = 12;

	public static Figure getRandomFigure() {

		double valueRand = Math.random()*rand;

		if(valueRand < rand/4)
			return getRandomRond();
		else if(valueRand < 2*rand/4)
			return getRandomRectangle();
		else if(valueRand < 3*rand/4)
			return getRandomCarre();
		else
			return getRandomSegment();
	}

	public static Surfacable getRandomSurfacable() {

		double valueRand = Math.random();

		if(valueRand < rand/3)
			return getRandomRond();
		else if(valueRand < 2*rand/3)
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
		return (int) (Math.round((Math.random()*valueX)));
	}

	private static int getRandomValueY() {
		return (int) (Math.round((Math.random()*valueY)));
	}

	private static int getRandomValueLong() {
		return (int) (Math.round((Math.random()*valueSeg)));
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

	public static void deplaceAllFigure(ArrayList<Point> list_Point, int deltaX, int deltaY) {
		list_Point.forEach(point -> point.deplace(deltaX, deltaY));
	}

	public static String toStringTabPoints(ArrayList<Point> list_Points) {

		//		list_Points.stream().forEach(p -> System.out.println(p.toString()));

		String s="[";
		for(Point p : list_Points)
			s+=p.toString();

		return s+"]";
	}

	public static ArrayList<Figure> genere(int nb_Figure){
		ArrayList<Figure> list_figure = new ArrayList<>();

		for(int index = 0; index < nb_Figure ; index++)
			list_figure.add(getRandomFigure());

		return list_figure;
	}

	public static Figure getFigureEn(Point pointInDessin, Dessin dess) {
		Figure figureCouvrePoint = null;

		Iterator<Figure> iterator_dessin = dess.getFigure().iterator();

		// On itère sur la liste de figure du dessin
		while(iterator_dessin.hasNext()) {
			// On vérifie si la figure courante couvre le point en paramètre
			if((figureCouvrePoint = (Figure)(iterator_dessin.next())).couvre(pointInDessin))
				// si c'est le cas, on renvoie la figure courante
				return figureCouvrePoint;
		}

		// si aucune figure du dessin ne couvre le point, on renvoie null

		return null;
	}

	public static ArrayList<Figure> trieProcheOrigine(Dessin dessin){
//			return dessin.getFigure()
//					.stream()
//					.sorted((f1,f2) -> f1.compareTo(f2))
//					.collect(Collectors.toList());
		Collections.sort(dessin.getFigure());
		return dessin.getFigure();
	}

}
