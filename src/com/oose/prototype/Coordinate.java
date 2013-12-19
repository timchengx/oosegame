package com.oose.prototype;

import java.io.Serializable;

/* Convert X,Y Location from View to Model */
public abstract class Coordinate implements Serializable {
	
	protected final int ERROR = -1;
	protected int resultX = ERROR;
	protected int resultY = ERROR;
	
	private static final long serialVersionUID = 6894533057253899957L;
	abstract public void convertToBoard(int x, int y);	// to View
	abstract public void convertToScreen(int x, int y);	// to Model
	
	/* called after convert */
	public int getX() {
		return resultX;
	}
	public int getY() {
		return resultY;
	}
	
}
