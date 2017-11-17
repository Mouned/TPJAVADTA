package main;

import utils.*;

import java.util.ArrayList;

import form.*;

public class TestForme {

	public static void main(String[] args) {

		ArrayList<Figure> list_figure = FigureUtilMap.genere(10);

		Dessin dessin = new Dessin(list_figure);
		dessin.affiche();
		System.out.println();
		//FigureUtil.trieDominant(dessin);
		dessin.affiche();


		//FigureUtilMap.afficheMap();
		//System.out.println(FigureUtilMap.getFigureIDMap("8"));

	}
}
