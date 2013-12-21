package com.oose.darkchess;

import java.util.Iterator;

import android.graphics.Bitmap;
import android.util.Log;


import com.oose.factory.ChineseChessPictureList;
import com.oose.factory.DarkChessBoardFactory;
import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

public class DarkChessBoard extends ChessBoard{

	private static final long serialVersionUID = -2522051701579026903L;

	public DarkChessBoard() {
		super(9, 10); // ChineseChessBoard's size

		/* call factory to create a new ChineseChessBoard */
		this.nowBoard = DarkChessBoardFactory.makeNewDarkChessBoard(this);
	}

	@Override
	public Iterator<ChessMan> iterator() {
		return new ChessIterator();
	}

	/* implements iterator */
	private class ChessIterator implements Iterator<ChessMan> {
		private final int totalX = 9;
		private final int totalY = 10;
		private int X = 0;
		private int Y = 0;

		@Override
		public boolean hasNext() {
			if (X < totalX) {
				return true;
			} else if (Y < totalY - 1) {
				X = 0;
				Y++;
				return true;
			}
			return false;
		}

		@Override
		public ChessMan next() {
			ChessMan currentChess = nowBoard[X][Y];
			if (X < totalX)
				X++;
			return currentChess;
		}

		@Override
		public void remove() {}

	}

	@Override
	public Bitmap getBackGround() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	@Override
	public void copy() throws CloneNotSupportedException {
		Log.d("timcheng", "start copy.");
		/* create a new ChessBoard state, copy all chessman to this state */
		snapshot = new DarkChessMan[boardXSize][boardYSize];
		for (int i = 0; i < boardXSize; i++) {
			for (int j = 0; j < boardYSize; j++) {
				if (nowBoard[i][j] == null)
					continue;
				snapshot[i][j] = nowBoard[i][j].clone();
			}
		}
	}
}
