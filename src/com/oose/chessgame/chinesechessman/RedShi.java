package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class RedShi extends ChessMan{

	public RedShi(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board, 6);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.red_shi);
	}
	@Override
	public boolean moveValid(int x, int y) {
		if(((0<=x && x<=2) || (7<=x && x<=9)) && (3<=y && y<=5)) { //鎖定九宮格
			if((Math.abs(x-currentX) == 1) && (Math.abs(y-currentY) == 1)) {
					return true;
			}
		}
		return false;
	}
	@Override
	public boolean eatValid(int x, int y) {
		// TODO Auto-generated method stub
		return moveValid(x,y);
	}

}
