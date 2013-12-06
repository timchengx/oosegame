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

public class ChineseChessBoard extends ChessBoard {
	public ChineseChessBoard() {
		super(4, 8, BitmapFactory.decodeResource(OOSEGame.getRes(),
				R.drawable.chinesechessboard));
		this.nowBoard = new ChessMan[4][8];
		this.previousBoard = null;
		this.previousPreviousBoard = null;

		int i,j;
		int swap;
		int randomA;
		int random[]={0,1,2,3,4,5,6,7,10,11,12,13,14,15,16,17,20,21,22,23,24,25,26,27,30,31,32,33,34,35,36,37};
		for(i=0;i<32;i++){
			randomA= (int) (Math.random() * 32);
			swap=random[i];
			random[i]=random[randomA];
			random[randomA]=swap;
		}
		
		i=random[0]/10;j=random[0]%10;
		this.nowBoard[i][j] = new RedCannon(i, j, ChessMan.RED, this);
		i=random[1]/10;j=random[1]%10;
		this.nowBoard[i][j] = new RedCannon(i, j, ChessMan.RED, this);
		i=random[2]/10;j=random[2]%10;
		this.nowBoard[i][j] = new RedGeneral(i, j, ChessMan.RED, this);
		i=random[3]/10;j=random[3]%10;
		this.nowBoard[i][j] = new RedSoldier(i, j, ChessMan.RED, this);
		i=random[4]/10;j=random[4]%10;
		this.nowBoard[i][j] = new RedSoldier(i, j, ChessMan.RED, this);
		i=random[5]/10;j=random[5]%10;
		this.nowBoard[i][j] = new RedSoldier(i, j, ChessMan.RED, this);
		i=random[6]/10;j=random[6]%10;
		this.nowBoard[i][j] = new RedSoldier(i, j, ChessMan.RED, this);
		i=random[7]/10;j=random[7]%10;
		this.nowBoard[i][j] = new RedSoldier(i, j, ChessMan.RED, this);
		i=random[8]/10;j=random[8]%10;
		this.nowBoard[i][j] = new RedCar(i, j, ChessMan.RED, this);
		i=random[9]/10;j=random[9]%10;
		this.nowBoard[i][j] = new RedCar(i, j, ChessMan.RED, this);
		i=random[10]/10;j=random[10]%10;
		this.nowBoard[i][j] = new RedElephant(i, j, ChessMan.RED, this);
		i=random[11]/10;j=random[11]%10;
		this.nowBoard[i][j] = new RedElephant(i, j, ChessMan.RED, this);
		i=random[12]/10;j=random[12]%10;
		this.nowBoard[i][j] = new RedHorse(i, j, ChessMan.RED, this);
		i=random[13]/10;j=random[13]%10;
		this.nowBoard[i][j] = new RedHorse(i, j, ChessMan.RED, this);
		i=random[14]/10;j=random[14]%10;
		this.nowBoard[i][j] = new RedShi(i, j, ChessMan.RED, this);
		i=random[15]/10;j=random[15]%10;
		this.nowBoard[i][j] = new RedShi(i, j, ChessMan.RED, this);
		i=random[16]/10;j=random[16]%10;
		this.nowBoard[i][j] = new BlackCannon(i, j, ChessMan.BLACK, this);
		i=random[17]/10;j=random[17]%10;
		this.nowBoard[i][j] = new BlackCannon(i, j, ChessMan.BLACK, this);
		i=random[18]/10;j=random[18]%10;
		this.nowBoard[i][j] = new BlackGeneral(i, j, ChessMan.BLACK, this);
		i=random[19]/10;j=random[19]%10;
		this.nowBoard[i][j] = new BlackSoldier(i, j, ChessMan.BLACK, this);
		i=random[20]/10;j=random[20]%10;
		this.nowBoard[i][j] = new BlackSoldier(i, j, ChessMan.BLACK, this);
		i=random[21]/10;j=random[21]%10;
		this.nowBoard[i][j] = new BlackSoldier(i, j, ChessMan.BLACK, this);
		i=random[22]/10;j=random[22]%10;
		this.nowBoard[i][j] = new BlackSoldier(i, j, ChessMan.BLACK, this);
		i=random[23]/10;j=random[23]%10;
		this.nowBoard[i][j] = new BlackSoldier(i, j, ChessMan.BLACK, this);
		i=random[24]/10;j=random[24]%10;
		this.nowBoard[i][j] = new BlackCar(i, j, ChessMan.BLACK, this);
		i=random[25]/10;j=random[25]%10;
		this.nowBoard[i][j] = new BlackCar(i, j, ChessMan.BLACK, this);
		i=random[26]/10;j=random[26]%10;
		this.nowBoard[i][j] = new BlackElephant(i, j, ChessMan.BLACK, this);
		i=random[27]/10;j=random[27]%10;
		this.nowBoard[i][j] = new BlackElephant(i, j, ChessMan.BLACK, this);
		i=random[28]/10;j=random[28]%10;
		this.nowBoard[i][j] = new BlackHorse(i, j, ChessMan.BLACK, this);
		i=random[29]/10;j=random[29]%10;
		this.nowBoard[i][j] = new BlackHorse(i, j, ChessMan.BLACK, this);
		i=random[30]/10;j=random[30]%10;
		this.nowBoard[i][j] = new BlackShi(i, j, ChessMan.BLACK, this);
		i=random[31]/10;j=random[31]%10;
		this.nowBoard[i][j] = new BlackShi(i, j, ChessMan.BLACK, this);
	
		/*
		 * int randomA; int randomB; ChessMan swap; for (int i = 0; i < 4; i++)
		 * { for (int j = 0; j < 8; j++) { randomA = (int) (Math.random() * 4);
		 * randomB = (int) (Math.random() * 8); swap =
		 * this.nowBoard[randomA][randomB]; this.nowBoard[randomA][randomB] =
		 * this.nowBoard[i][j]; this.nowBoard[i][j] = swap;
		 * this.nowBoard[i][j].setXY(i, j); } }
		 */
	}

	@Override
	public Iterator<ChessMan> iterator() {
		return new ChessIterator();
	}

	private class ChessIterator implements Iterator<ChessMan> {
		private final int totalX = 4;
		private final int totalY = 8;
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
			if (X < 4)
				X++;
			return currentChess;
		}

		@Override
		public void remove() {
		}

	}

	@Override
	public ChessMan getChess(int x, int y) {
		if (x < 4 && x >= 0 && y < 8 && y >= 0)
			return nowBoard[x][y];
		return null;
	}

	@Override
	public boolean hasChess(int x, int y) {
		if (x < 4 && x >= 0 && y < 8 && y >= 0)
			if (nowBoard[x][y] != null)
				return true;
		return false;
	}
}
