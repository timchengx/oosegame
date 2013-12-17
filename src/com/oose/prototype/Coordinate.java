package com.oose.prototype;

import java.io.Serializable;

public abstract class Coordinate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6894533057253899957L;
	abstract public void convertToBoard(int x, int y);
	abstract public void convertToScreen(int x, int y);
	abstract public int getX();
	abstract public int getY();
}
