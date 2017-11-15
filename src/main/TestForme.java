package main;

import utils.*;

import java.util.ArrayList;

import form.*;
import interfaceUtils.Surfacable;

public class TestForme {

	public static void main(String[] args) {
//		Rond r1 = FigureUtil.getRandomRond();
//		Rond r2 = FigureUtil.getRandomRond();
//		r1.affiche();
//		r2.affiche();
//
//		Carre c = FigureUtil.getRandomCarre();
//		Rectangle rec = FigureUtil.getRandomRectangle();
//
//		c.affiche();
//		rec.affiche();
//
//		Figure f = FigureUtil.getRandomFigure();
//
//		f.affiche();
//
//		Surfacable surf = FigureUtil.getRandomSurfacable();
//
//		surf.affiche();
//
//		ArrayList<Point> test_List = FigureUtil.getPoints(r1, r2, f, c, rec);
//
//		System.out.println(FigureUtil.toStringTabPoints(test_List));
		
		Rond r1 = new Rond(new Point(20,20),13);
		Rectangle rec = new Rectangle(new Point(0,0),10,10);
		Point p = new Point(11,11);
		Point p2 = new Point(8,11);
		
		System.out.println(rec.couvre(p));
		System.out.println(rec.couvre(p2));
		System.out.println(r1.couvre(p));
		System.out.println(r1.couvre(p2));
	}
}
