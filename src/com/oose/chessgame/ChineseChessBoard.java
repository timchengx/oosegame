package com.oose.chessgame;

import java.util.Iterator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.oose.chessgame.chinesechessman.RedCannon;
import com.oose.chessgame.chinesechessman.RedGeneral;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class ChineseChessBoard extends ChessBoard{
	public ChineseChessBoard() {
		this.nowBoard = new ChessMan[10][9];
		this.previousBoard = null;
		this.previousPreviousBoard = null;
		this.backGround = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinesechessboard);
		
		this.nowBoard[2][1] = new RedCannon(2,1,ChessMan.RED);
		this.nowBoard[0][4] = new RedGeneral(0,4,ChessMan.RED);
	}

	@Override
	public Iterator<ChessMan> iterator() {
		return new ChessIterator();
	}
	private class ChessIterator implements Iterator<ChessMan>{
		private final int totalX = 10;
		private final int totalY = 9;
		private int X = 0;
		private int Y = 0;
		@Override
		public boolean hasNext() {
			if(X < totalX) {
				return true;
			}
			else
				if(Y < totalY - 1 ) {
					X = 0;
					Y++;
					return true;
				}
			return false;
		}

		@Override
		public ChessMan next() {
			//Log.d("kerker", X +" "+ Y);
			ChessMan currentChess = nowBoard[X][Y];
			if(X < 10)
				X++;
			return currentChess;
		}

		@Override
		public void remove() {}
		
	}
	@Override
	public Bitmap getBackground() {
		// TODO Auto-generated method stub
		return backGround;
	}
	public ChessMan getChess(int x, int y) {
		if(x < 10 && x >= 0 && y < 9 && y >= 0)
			return nowBoard[x][y];
		return null;
	}

	@Override
	public boolean hasChess(int x, int y) {
		if(x < 10 && x >= 0 && y < 9 && y >= 0)
			if(nowBoard[x][y] != null)
				return true;
		return false;
	}

	@Override
	public void setBoard(int x, int y, ChessMan c) {
		nowBoard[x][y] = null;
		nowBoard[x][y] = c;
	}
}
