package com.oose.prototype;

import java.io.Serializable;

import android.graphics.Bitmap;

public abstract class ChessMan implements Cloneable, Serializable, Observable {

	private static final long serialVersionUID = 1732597257710741013L;
	public static final int RED = 1;
	public static final int BLACK = 2;

	/*
	 * For moving chess from chessboard and ChessMan's move and eat action is
	 * valid or not
	 */
	protected ChessBoard board;
	protected int belongTo; // Who's Chess?

	/* current location in ChessBoard */
	protected int currentX;
	protected int currentY;

	/* move and eat rules, implement after extend */
	abstract public boolean move(int x, int y);

	abstract public boolean eat(int x, int y);

	/* specified ChessMan's Icon, implement after extend */
	abstract public Bitmap getIcon();

	abstract public Bitmap getSelectedIcon();

	/* implements Cloneable */
	@Override
	abstract public ChessMan clone() throws CloneNotSupportedException;

	public ChessMan(int x, int y, int belong, ChessBoard board) {
		this.board = board;
		this.currentX = x;
		this.currentY = y;
		this.belongTo = belong;
	}

	/* copy constructor */
	public ChessMan(ChessMan cm) {
		this(cm.currentX, cm.currentY, cm.belongTo, cm.board);
	}

	/* implements Observable */
	@Override
	public void notifyObservers(Object o) {
		Observer observer = board;
		observer.update(this, o);
	}

	/* Getter and Setter */
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

	public int getBelong() {
		return belongTo;
	}

	/*
	 * called if move or eat method is vaild move chessman in chessboard
	 */
	protected void inBoardMoveChess(int x, int y) {
		this.notifyObservers(null);
		this.setXY(x, y);
		this.notifyObservers(this);
	}

}