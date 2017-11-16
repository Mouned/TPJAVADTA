package main;

import utils.*;

import java.util.ArrayList;

import form.*;
import interfaceUtils.Surfacable;

public class TestForme {

	public static void main(String[] args) {

		ArrayList<Figure> list_figure = FigureUtil.genere(10);

		Dessin dessin = new Dessin(list_figure);
		dessin.affiche();
		FigureUtil.trieDominant(dessin);
		dessin.affiche();

	}
}
