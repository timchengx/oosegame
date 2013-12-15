package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class RedGeneral extends ChineseChessMan{

	public RedGeneral(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.RED, board);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.red_general);
	}
	@Override
	public boolean moveValid(int x, int y) {

		if(((0<=x && x<=2) || (7<=x && x<=9)) && (3<=y && y<=5)) { //鎖定九宮格
			if(Math.abs(x-currentX) + Math.abs(y-currentY) == 1 ) {
					return true;
			}	
		}
			return false;
	}
	@Override
	public boolean eatValid(int x, int y) {
		return moveValid(x,y);
	}

}
