package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import couleur.Couleur;
import exception.PointInvalideCoordException;
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
	private final static int rand_Couleur = 15;

	public static Figure getRandomFigure() throws PointInvalideCoordException {

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

	public static Surfacable getRandomSurfacable() throws PointInvalideCoordException {

		double valueRand = Math.random();

		if(valueRand < rand/3)
			return getRandomRond();
		else if(valueRand < 2*rand/3)
			return getRandomRectangle();
		else 
			return getRandomCarre();
	}

	public static Rond getRandomRond() throws PointInvalideCoordException {
		return new Rond(getRandomPoint(), getRandomValueLong(),getRandomCouleur());
	}

	public static Rectangle getRandomRectangle() throws PointInvalideCoordException {
		return new Rectangle(getRandomPoint(),getRandomValueLong(),getRandomValueLarg(),getRandomCouleur());
	}

	public static Carre getRandomCarre() throws PointInvalideCoordException {
		Carre c = new Carre(getRandomPoint(),getRandomValueLong(),getRandomCouleur());
		return c;
	}

	public static Segment getRandomSegment() throws PointInvalideCoordException {
		double rand = Math.random();

		if(rand > 0.5)
			return new Segment(getRandomPoint(),getRandomValueLong(),true,getRandomCouleur());
		else
			return new Segment(getRandomPoint(),getRandomValueLong(),false,getRandomCouleur());
	}

	private static Point getRandomPoint() throws PointInvalideCoordException {
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

	private static Couleur getRandomCouleur(){

		double valueRand = Math.random()*rand_Couleur;

		if(valueRand < rand_Couleur/5)
			return Couleur.Rouge;
		else if(valueRand < 2*rand_Couleur/5)
			return Couleur.Vert;
		else if(valueRand < 3*rand_Couleur/5)
			return Couleur.Bleu;
		else if(valueRand < 4*rand_Couleur/5)
			return Couleur.Jaune;
		else
			return Couleur.Noir;
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

	public static ArrayList<Figure> genere(int nb_Figure) throws PointInvalideCoordException{
		ArrayList<Figure> list_figure = new ArrayList<>();

		for(int index = 0; index < nb_Figure ; index++)
			list_figure.add(getRandomFigure());

		return list_figure;
	}

	public static Optional<Figure> getFigureEn(Point pointInDessin, Dessin dess) {
//		Optional<Figure> figureCouvrePoint = null;
//
//		Iterator<Figure> iterator_dessin = dess.getFigure().iterator();
//
//		// On itère sur la liste de figure du dessin
//		while(iterator_dessin.hasNext()) {
//			// On vérifie si la figure courante couvre le point en paramètre
//			if((figureCouvrePoint = (Optional<Figure>)(iterator_dessin.next())).couvre(pointInDessin))
//				// si c'est le cas, on renvoie la figure courante
//				return figureCouvrePoint;
//		}
		return dess.getFigure().stream()
				.filter(f -> f.couvre(pointInDessin))
				.findFirst();
	}

	public static ArrayList<Figure> trieProcheOrigine(Dessin dessin){
		//			return dessin.getFigure()
		//					.stream()
		//					.sorted((f1,f2) -> f1.compareTo(f2))
		//					.collect(Collectors.toList());
		Collections.sort(dessin.getFigure());
		return dessin.getFigure();
	}

	//	public static ArrayList<Surfacable> trieDominant(Dessin dessin){
	//		return dessin.getFigure()
	//			.stream()
	//			.filter(f -> f instanceof Surfacable)
	//			.sorted()
	//			.collect(Collectors.toList());
	//	}
	
	
	public static void imprime(Dessin dessin) throws IOException, PointInvalideCoordException {
		File file = new File("File_Dessin/MonDessin.save");
		PrintWriter sortie = new PrintWriter(new FileOutputStream(file));
		dessin.getFigure().stream()
						.forEach(f -> sortie.println(f));
		for(int x=0;x<valueX;x++){
			sortie.print("=");
		}
		sortie.println();
		for(int y=0;y<valueY;y++){
			for(int x=0;x<valueX;x++){
				Optional<Figure> figure = getFigureEn(new Point(x,y),dessin);
				if(figure.isPresent()){
					sortie.print(figure.get().getCouleur().toString());
				} else {
					sortie.print(" ");
				}
			}
			sortie.println();
		}
		System.out.println("Impression sous " + file.getAbsolutePath());
		sortie.close();
		
	}
	
	public static void sauvegarde(Dessin dessin)throws IOException{
		File file = new File("File_Dessin/MonDessin.save");
		ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(file));
		
		sortie.writeObject(dessin);		
		System.out.println("Sauvegarde sous "+ file.getAbsolutePath());
		
		sortie.close();
	}
	
	public static Dessin charge(String filename)throws IOException, ClassNotFoundException{
		Dessin dessin;
		
		try {
			ObjectInputStream entree = new ObjectInputStream(new FileInputStream(filename));
			dessin = (Dessin) entree.readObject();
			entree.close();
		}catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé : " + e.getMessage());
			dessin = new Dessin();
		}
		return dessin;
	}

}
