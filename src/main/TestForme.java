package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import form.Figure;
import utils.Dessin;
import utils.FigureUtil;
import utils.FigureUtilMap;

public class TestForme {

	public static void main(String[] args) {

		ArrayList<Figure> list_figure = FigureUtilMap.genere(10);

		Dessin dessin = new Dessin(list_figure);
		dessin.affiche();
		System.out.println();
		//FigureUtil.trieDominant(dessin);
		dessin.affiche();

		try {
			FigureUtil.imprime(dessin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//FigureUtilMap.afficheMap();
		//System.out.println(FigureUtilMap.getFigureIDMap("8"));
		
		Date d = new Date();
		
		System.out.println(d.toString());

	}
}
