package utils;

import java.util.ArrayList;

import form.Figure;

public class Dessin {

	private ArrayList<Figure> list_figure;	
	
	public Dessin(ArrayList<Figure> list_figure) {
		this.list_figure=list_figure;
	}
	
	public boolean add(Figure fig) {
		return list_figure.add(fig);
	}
	
	public ArrayList<Figure> getFigure(){
		return list_figure;
	}
}
