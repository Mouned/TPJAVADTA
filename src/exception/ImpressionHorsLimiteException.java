package exception;

import form.Point;

public class ImpressionHorsLimiteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImpressionHorsLimiteException(Point p) {
		super("Point : "+p.toString()+" en dehors des limites du dessins");
	}
}
