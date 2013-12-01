package com.oose.chessgame;

import android.graphics.Bitmap;

public abstract class ChessMan {
	protected Bitmap icon;
	public static final int RED = 1;
	public static final int BLACK = 2;
	protected int belongTo;
	protected int currentX;
	protected int currentY;
	abstract public boolean moveValid(int x, int y);
	public int getX() {
		return currentX;
	}
	public int getY() {
		return currentY;
	}
	public Bitmap getIcon() {
		return icon;
	}
} 
