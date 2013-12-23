package com.oose.prototype;

import java.io.Serializable;
import java.util.Iterator;

import android.graphics.Bitmap;

/* MVC's Model */
public abstract class ChessBoard implements Iterable<ChessMan>, Observer, Fallback, 
		Serializable {

	private static final long serialVersionUID = 8448462241599153803L;

	protected ChessMan[][] nowBoard;	// current Board state
	/* 
	 * previous and previous previous state
	 * for the fallback function
	 */
	protected ChessMan[][] pBoard;
	protected ChessMan[][] ppBoard;
	
	/* 
	 * user's action is select and move/eat.
	 * temperate save's the state
	 * before user complete his action
	 */
	protected ChessMan[][] snapshot;

	/* how big is this ChessBoard */
	protected int boardXSize;
	protected int boardYSize;

	public ChessBoard(int x, int y) {
		this.boardXSize = x;
		this.boardYSize = y;
		this.nowBoard = null;
		this.pBoard = null;
		this.ppBoard = null;
	}
	/* Save the current state before ChessMan move */
	abstract public void copy() throws CloneNotSupportedException;

	/* For the View to refresh screen */
	abstract class ChessIterator implements Iterator<ChessMan> {};
	
	/* ChessBoard Background */
	abstract public Bitmap getBackGround();

	/* Save previous board state */
	public void savePreviousBoard() {
		if (pBoard != null)
			ppBoard = pBoard;
		pBoard = snapshot;
		snapshot = null;
	}

	/* Fallback to previous board state */
	@Override
	public boolean fallback() {
		nowBoard = ppBoard;
		pBoard = null;
		ppBoard = null;
		return true;
	}

	/* Determine can fallback or not */
	@Override
	public boolean canFallback() {
		if (ppBoard != null)
			return true;
		return false;
	}
	
	/* Grab chess from board */
	public ChessMan getChess(int x, int y) {
		if (x < boardXSize && x >= 0 && y < boardYSize && y >= 0)
			return nowBoard[x][y];
		return null;
	}
	
	/* called by Observer, change ChassMan location */
	private void setChess(int x, int y, ChessMan c) {
		nowBoard[x][y] = c;
	}
	
	/* check board */
	public boolean hasChess(int x, int y) {
		if (x < boardXSize && x >= 0 && y < boardYSize && y >= 0)
			if (nowBoard[x][y] != null)
				return true;
		return false;
	}
	
	public int getBoardXSize() {
		return boardXSize;
	}
	
	public int getBoardYSize() {
		return boardYSize;
	}
	
	/* implements Observer */
	@Override
	public void update(Observable arg0, Object arg1) {
        ChessMan cm = (ChessMan) arg0;
        this.setChess(cm.getX(), cm.getY(), (ChessMan) arg1);
}

}
