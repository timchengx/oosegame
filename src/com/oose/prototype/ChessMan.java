package com.oose.prototype;

import java.io.Serializable;
import java.util.Observable;

import android.graphics.Bitmap;

public abstract class ChessMan extends Observable implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1732597257710741013L;
	public static final int RED = 1;
	public static final int BLACK = 2;
	protected ChessBoard board;
	protected int belongTo;
	protected int currentX;
	protected int currentY;
	abstract public boolean move(int x, int y);
	abstract public boolean eat(int x, int y);
	public ChessMan(int x, int y, int belong, ChessBoard board) {
		this.board = board;
		this.currentX = x;
		this.currentY = y;
		this.belongTo = belong;
		addObserver(board);
	}

	public ChessMan(ChessMan cm) {
		this(cm.currentX, cm.currentY, cm.belongTo, cm.board);
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
	protected void inBoardMoveChess(int x, int y) {
		this.setChanged();
		this.notifyObservers(null);
		this.setXY(x, y);
		this.setChanged();
		this.notifyObservers(this);
	}
	@Override
	abstract public ChessMan clone() throws CloneNotSupportedException;
} 