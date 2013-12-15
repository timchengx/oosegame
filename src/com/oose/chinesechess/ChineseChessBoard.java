package com.oose.chinesechess;

import java.util.Iterator;

import android.graphics.BitmapFactory;

import com.oose.chessgame.chinesechessman.BlackCannon;
import com.oose.chessgame.chinesechessman.BlackCar;
import com.oose.chessgame.chinesechessman.BlackElephant;
import com.oose.chessgame.chinesechessman.BlackGeneral;
import com.oose.chessgame.chinesechessman.BlackHorse;
import com.oose.chessgame.chinesechessman.BlackShi;
import com.oose.chessgame.chinesechessman.BlackSoldier;
import com.oose.chessgame.chinesechessman.RedCannon;
import com.oose.chessgame.chinesechessman.RedCar;
import com.oose.chessgame.chinesechessman.RedElephant;
import com.oose.chessgame.chinesechessman.RedGeneral;
import com.oose.chessgame.chinesechessman.RedHorse;
import com.oose.chessgame.chinesechessman.RedShi;
import com.oose.chessgame.chinesechessman.RedSoldier;
import com.oose.factory.ChineseChessBoardFactory;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

public class ChineseChessBoard extends ChessBoard {
	public ChineseChessBoard() {
		super(10, 9, BitmapFactory.decodeResource(OOSEGame.getRes(),
				R.drawable.chinesechessboard));
		this.nowBoard =  ChineseChessBoardFactory.makeNewChineseChessBoard(this);
	}

	@Override
	public Iterator<ChessMan> iterator() {
		return new ChessIterator();
	}

	private class ChessIterator implements Iterator<ChessMan> {
		private final int totalX = 10;
		private final int totalY = 9;
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
			// Log.d("kerker", X +" "+ Y);
			ChessMan currentChess = nowBoard[X][Y];
			if (X < 10)
				X++;
			return currentChess;
		}

		@Override
		public void remove() {
		}

	}

	@Override
	public ChineseChessMan getChess(int x, int y) {
		if (x < 10 && x >= 0 && y < 9 && y >= 0)
			return (ChineseChessMan) nowBoard[x][y];
		return null;
	}

	@Override
	public boolean hasChess(int x, int y) {
		if (x < 10 && x >= 0 && y < 9 && y >= 0)
			if (nowBoard[x][y] != null)
				return true;
		return false;
	}
}
