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
	public ChessMan(int x, int y, int belong) {
		this.currentX = x;
		this.currentY = y;
		this.belongTo = belong;
	}
	public int getX() {
		return currentX;
	}
	public int getY() {
		return currentY;
	}
	public void setXY(int x, int y) {
		this.currentX = x;
		this.currentY = y;
	}
	public Bitmap getIcon() {
		return icon;
	}
	public int getBelong() {
		return belongTo;
	}
} 