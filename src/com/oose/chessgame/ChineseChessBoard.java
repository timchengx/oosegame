package com.oose.chessgame;

import java.util.Iterator;

import com.oose.chessgame.chinesechessman.RedCannon;
import com.oose.game.OOSEGame;
import com.oose.game.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ChineseChessBoard extends ChessBoard{
	public ChineseChessBoard() {
		super();
		this.nowBoard = new ChessMan[10][9];
		this.previousBoard = null;
		this.previousPreviousBoard = null;
		this.nowBoard[2][1] = new RedCannon(2,1);
		this.backGround = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinesechessboard);
	}

	@Override
	public Iterator<ChessMan> iterator() {
		// TODO Auto-generated method stub
		return new ChessIterator();
	}
	private class ChessIterator implements Iterator<ChessMan>{
		private final int totalX = 10;
		private final int totalY = 9;
		private int X = 0;
		private int Y = 0;
		@Override
		public boolean hasNext() {
			if(X < totalX && Y < totalY)
				return true;
			return false;
		}

		@Override
		public ChessMan next() {
			ChessMan currentChess = nowBoard[X][Y];
			X++; Y++;
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
}
