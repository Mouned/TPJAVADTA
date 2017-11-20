package main;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;

import exception.PointInvalideCoordException;
import form.Figure;
import utils.Dessin;
import utils.FigureUtil;
import utils.FigureUtilMap;

public class TestForme {

	public static void main(String[] args) {

		ArrayList<Figure> list_figure = null;
		try {
			list_figure = FigureUtilMap.genere(10);
		} catch (PointInvalideCoordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Dessin dessin = new Dessin(list_figure);
		//dessin.affiche();
		//		System.out.println();
		//FigureUtil.trieDominant(dessin);
		//	dessin.affiche();

		try {
			FigureUtil.imprime(dessin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PointInvalideCoordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}

		//FigureUtilMap.afficheMap();
		//System.out.println(FigureUtilMap.getFigureIDMap("8"));

		DayOfWeek dow = DayOfWeek.MONDAY;
		System.out.println(dow.getValue());
		System.out.println(dow.plus(4));

	}
}
