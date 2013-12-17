package com.oose.prototype;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import android.graphics.Bitmap;

public abstract class ChessBoard implements Iterable<ChessMan>, Observer {
	protected ChessMan[][] nowBoard;
	protected ChessMan[][] pBoard;
	protected ChessMan[][] ppBoard;
	protected ChessMan[][] snapshot;
	protected int boardXSize;
	protected int boardYSize;
	
	public ChessBoard(int x, int y) {
		this.boardXSize = x;
		this.boardYSize = y;
		this.nowBoard = null;
		this.pBoard = null;
		this.ppBoard = null;
	}
	abstract public void copy();
	abstract class ChessIterator implements Iterator<ChessMan>{};
	
	public ChessMan getChess(int x, int y) {
		if (x < boardXSize && x >= 0 && y < boardYSize && y >= 0)
			return nowBoard[x][y];
		return null;
	}
	
	public boolean hasChess(int x, int y) {
		if (x < boardXSize && x >= 0 && y < boardYSize && y >= 0)
			if (nowBoard[x][y] != null)
				return true;
		return false;
	}

	abstract public Bitmap getBackGround();
	public void savePreviousBoard() {
		if(pBoard != null)
			ppBoard = pBoard;
		pBoard = snapshot;
		snapshot = null;
	}
	private void setBoard(int x, int y, ChessMan c) {
		nowBoard[x][y] = c;
	}
//	public int getBoardXSize() {
//		return boardXSize;
//	}
//	public int getBoardYSize() {
//		return boardYSize;
//	}
	@Override
	public void update(Observable arg0, Object arg1) {
		ChessMan cm = (ChessMan) arg0;
		this.setBoard(cm.getX(), cm.getY(), (ChessMan)arg1);
	}
}