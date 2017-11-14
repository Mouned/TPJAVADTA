package main;

import utils.*;
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
		
		Point[] test_Tab = FigureUtil.getPoints(r1, r2, f, c, rec);
		
		System.out.println(FigureUtil.toStringTabPoints(test_Tab));
	}
}
