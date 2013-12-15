package com.oose.prototype;

public abstract class Coordinate {
	abstract public void convertToBoard(int x, int y);
	abstract public void convertToScreen(int x, int y);
	abstract public int getX();
	abstract public int getY();
}
