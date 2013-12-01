package com.oose.chessgame;

import java.util.Iterator;

import android.graphics.Bitmap;

public abstract class ChessBoard implements Iterable<ChessMan> {
	protected ChessMan nowBoard[][];
	protected ChessMan previousBoard[][];
	protected ChessMan previousPreviousBoard[][];
	private int boardXSize;
	private int boardYSize;
	private Bitmap backGround;
	public ChessBoard(int x, int y, Bitmap bg) {
		boardXSize = x;
		boardYSize = y;
		backGround = bg;
	}

	abstract class ChessIterator implements Iterator<ChessMan>{};
	abstract public ChessMan getChess(int x, int y);
	abstract public boolean hasChess(int x, int y);
	public void setBoard(int x, int y, ChessMan c) {
		nowBoard[x][y] = c;
	}
	public void removeChess(int x, int y) {
		nowBoard[x][y] = null;
	}
	public int getBoardXSize() {
		return boardXSize;
	}
	public int getBoardYSize() {
		return boardYSize;
	}
	public Bitmap getBackGround() {
		return backGround;
	}
}
