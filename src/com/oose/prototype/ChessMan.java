package com.oose.prototype;

import android.graphics.Bitmap;

public abstract class ChessMan {
	public static final int RED = 1;
	public static final int BLACK = 2;
	protected ChessBoard board;
	protected int belongTo;
	protected int currentX;
	protected int currentY;
	abstract public boolean moveValid(int x, int y);
	abstract public boolean eatValid(int x, int y);
	public ChessMan(int x, int y, int belong, ChessBoard board) {
		this.board = board;
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
	abstract public Bitmap getIcon();
	abstract public Bitmap getSelectedIcon();
	public int getBelong() {
		return belongTo;
	}
} 