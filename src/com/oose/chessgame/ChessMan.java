package com.oose.chessgame;

import android.graphics.Bitmap;

public abstract class ChessMan {
	protected Bitmap icon;
	public static final int RED = 1;
	public static final int BLACK = 2;
	protected ChessBoard board;
	protected int level;
	protected boolean visible = false;
	protected int belongTo;
	protected int currentX;
	protected int currentY;

	abstract public boolean moveValid(int x, int y);

	abstract public boolean eatValid(int x, int y);

	public ChessMan(int x, int y, int belong, ChessBoard board, int level) {
		this.board = board;
		this.level = level;
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

	public int getLevel() {
		return level;
	}

	public void open() {
	}

	public boolean isVisible() {
		return visible;
	}
}