package com.oose.chessgame;

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
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class ChineseChessBoard extends ChessBoard{
	public ChineseChessBoard() {
		super(10, 9, BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinesechessboard));
		this.nowBoard = new ChessMan[10][9];
		this.previousBoard = null;
		this.previousPreviousBoard = null;
		
		this.nowBoard[0][0] = new RedCannon(0,0,ChessMan.RED, this);
		this.nowBoard[0][1] = new RedCannon(0,1,ChessMan.RED, this);
		this.nowBoard[0][2] = new RedGeneral(0,2,ChessMan.RED, this);
		this.nowBoard[0][3] = new RedSoldier(0,3,ChessMan.RED, this);
		this.nowBoard[0][4] = new RedSoldier(0,4,ChessMan.RED, this);
		this.nowBoard[0][5] = new RedSoldier(0,5,ChessMan.RED, this);
		this.nowBoard[0][6] = new RedSoldier(0,6,ChessMan.RED, this);
		this.nowBoard[0][7] = new RedSoldier(0,7,ChessMan.RED, this);
		this.nowBoard[1][0] = new RedCar(1,0,ChessMan.RED, this);
		this.nowBoard[1][1] = new RedCar(1,1,ChessMan.RED, this);
		this.nowBoard[1][2] = new RedElephant(1,2,ChessMan.RED, this);
		this.nowBoard[1][3] = new RedElephant(1,3,ChessMan.RED, this);
		this.nowBoard[1][4] = new RedHorse(1,4,ChessMan.RED, this);
		this.nowBoard[1][5] = new RedHorse(1,5,ChessMan.RED, this);
		this.nowBoard[1][6] = new RedShi(1,6,ChessMan.RED, this);
		this.nowBoard[1][7] = new RedShi(1,7,ChessMan.RED, this);
		this.nowBoard[2][0] = new BlackCannon(2,0,ChessMan.BLACK, this);
		this.nowBoard[2][1] = new BlackCannon(2,1,ChessMan.BLACK, this);
		this.nowBoard[2][2] = new BlackGeneral(2,2,ChessMan.BLACK, this);
		this.nowBoard[2][3] = new BlackSoldier(2,3,ChessMan.BLACK, this);
		this.nowBoard[2][4] = new BlackSoldier(2,4,ChessMan.BLACK, this);
		this.nowBoard[2][5] = new BlackSoldier(2,5,ChessMan.BLACK, this);
		this.nowBoard[2][6] = new BlackSoldier(2,6,ChessMan.BLACK, this);
		this.nowBoard[2][7] = new BlackSoldier(2,7,ChessMan.BLACK, this);
		this.nowBoard[3][0] = new BlackCar(3,0,ChessMan.BLACK, this);
		this.nowBoard[3][1] = new BlackCar(3,1,ChessMan.BLACK, this);
		this.nowBoard[3][2] = new BlackElephant(3,2,ChessMan.BLACK, this);
		this.nowBoard[3][3] = new BlackElephant(3,3,ChessMan.BLACK, this);
		this.nowBoard[3][4] = new BlackHorse(3,4,ChessMan.BLACK, this);
		this.nowBoard[3][5] = new BlackHorse(3,5,ChessMan.BLACK, this);
		this.nowBoard[3][6] = new BlackShi(3,6,ChessMan.BLACK, this);
		this.nowBoard[3][7] = new BlackShi(3,7,ChessMan.BLACK, this);

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
}
