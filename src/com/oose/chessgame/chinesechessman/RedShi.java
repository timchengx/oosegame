package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class RedShi extends ChineseChessMan{

	public RedShi(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.RED, board);
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
