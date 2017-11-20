package utils;

import java.io.Serializable;
import java.util.ArrayList;

import form.Figure;

public class Dessin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Figure> list_figure;	

	public Dessin(ArrayList<Figure> list_figure) {
		this.list_figure=list_figure;
	}
	
	public Dessin() {
		
	}

	public boolean add(Figure fig) {
		return list_figure.add(fig);
	}

	public ArrayList<Figure> getFigure(){
		return list_figure;
	}

	public void affiche() {
		list_figure
		.stream()
		.forEach(System.out::println);
	}
}
