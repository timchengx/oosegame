package com.oose.chessgame;

import java.util.Iterator;

import android.graphics.Bitmap;
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
		this.nowBoard = new ChessMan[10][9];
		this.previousBoard = null;
		this.previousPreviousBoard = null;
		this.backGround = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinesechessboard);
		
		this.nowBoard[2][1] = new RedCannon(2,1,ChessMan.RED);
		this.nowBoard[2][7] = new RedCannon(2,7,ChessMan.RED);
		this.nowBoard[0][4] = new RedGeneral(0,4,ChessMan.RED);
		this.nowBoard[3][0] = new RedSoldier(3,0,ChessMan.RED);
		this.nowBoard[3][2] = new RedSoldier(3,2,ChessMan.RED);
		this.nowBoard[3][4] = new RedSoldier(3,4,ChessMan.RED);
		this.nowBoard[3][6] = new RedSoldier(3,6,ChessMan.RED);
		this.nowBoard[3][8] = new RedSoldier(3,8,ChessMan.RED);
		this.nowBoard[0][0] = new RedCar(0,0,ChessMan.RED);
		this.nowBoard[0][8] = new RedCar(0,8,ChessMan.RED);
		this.nowBoard[0][2] = new RedElephant(0,2,ChessMan.RED);
		this.nowBoard[0][6] = new RedElephant(0,6,ChessMan.RED);
		this.nowBoard[0][1] = new RedHorse(0,1,ChessMan.RED);
		this.nowBoard[0][7] = new RedHorse(0,7,ChessMan.RED);
		this.nowBoard[0][3] = new RedShi(0,3,ChessMan.RED);
		this.nowBoard[0][5] = new RedShi(0,5,ChessMan.RED);
		this.nowBoard[7][1] = new BlackCannon(7,1,ChessMan.BLACK);
		this.nowBoard[7][7] = new BlackCannon(7,7,ChessMan.BLACK);
		this.nowBoard[9][4] = new BlackGeneral(9,4,ChessMan.BLACK);
		this.nowBoard[6][0] = new BlackSoldier(6,0,ChessMan.BLACK);
		this.nowBoard[6][2] = new BlackSoldier(6,2,ChessMan.BLACK);
		this.nowBoard[6][4] = new BlackSoldier(6,4,ChessMan.BLACK);
		this.nowBoard[6][6] = new BlackSoldier(6,6,ChessMan.BLACK);
		this.nowBoard[6][8] = new BlackSoldier(6,8,ChessMan.BLACK);
		this.nowBoard[9][0] = new BlackCar(9,0,ChessMan.BLACK);
		this.nowBoard[9][8] = new BlackCar(9,8,ChessMan.BLACK);
		this.nowBoard[9][2] = new BlackElephant(9,2,ChessMan.BLACK);
		this.nowBoard[9][6] = new BlackElephant(9,6,ChessMan.BLACK);
		this.nowBoard[9][1] = new BlackHorse(9,1,ChessMan.BLACK);
		this.nowBoard[9][7] = new BlackHorse(9,7,ChessMan.BLACK);
		this.nowBoard[9][3] = new BlackShi(9,3,ChessMan.BLACK);
		this.nowBoard[9][5] = new BlackShi(9,5,ChessMan.BLACK);

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
		nowBoard[x][y] = c;
	}
	
	@Override
	public void removeChess(int x, int y) {
		nowBoard[x][y] = null;
	}
}
