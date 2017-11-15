package main;

import utils.*;

import java.util.ArrayList;

import form.*;
import interfaceUtils.Surfacable;

public class TestForme {

	public static void main(String[] args) {
		Rond r1 = FigureUtil.getRandomRond();
		Rond r2 = FigureUtil.getRandomRond();
		r1.affiche();
		r2.affiche();

		Carre c = FigureUtil.getRandomCarre();
		Rectangle rec = FigureUtil.getRandomRectangle();

		c.affiche();
		rec.affiche();

		Figure f = FigureUtil.getRandomFigure();

		f.affiche();

		Surfacable surf = FigureUtil.getRandomSurfacable();

		surf.affiche();

		ArrayList<Point> test_List = FigureUtil.getPoints(r1, r2, f, c, rec);
		
		System.out.println(FigureUtil.toStringTabPoints(test_List));
		
		Point p = new Point(11,11);
		Point p2 = new Point(8,11);
		Point p3 = new Point(8,11);
		
		Object o = p2;
		System.out.println(p3.equals(o));
		System.out.println(o.equals(p3));
		
		
		System.out.println(rec.couvre(p));
		System.out.println(rec.couvre(p2));
		System.out.println(r1.couvre(p));
		System.out.println(r1.couvre(p2));
		
		Segment seg1 = new Segment(new Point(1,1), 10,true);
		Segment seg2 = new Segment(new Point(1,1), 10,false);
		
		System.out.println(seg1.couvre(new Point(1,5)));
		System.out.println(seg2.couvre(new Point(5,1)));
		
		
		FigureUtil.deplaceAllFigure(test_List, 5, 5);
		System.out.println(FigureUtil.toStringTabPoints(test_List));
	}
}
