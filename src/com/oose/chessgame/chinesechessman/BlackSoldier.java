package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class BlackSoldier extends ChessMan{

	public BlackSoldier(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board, 1);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.black_soldier);
	}
	public boolean moveValid(int x, int y) { 
		if(currentX == x && currentX <= 4) {
			if(Math.abs(currentY-y) == 1 ) { 
				return true;
			}
		}
		else if (currentY == y){  
			if(currentX > x) {
				if((currentX - 1) == x) {
				 return true;
				}
			}
		}
		return false;
	}
	public boolean eatValid(int x, int y) {
		if(moveValid(x, y) == true){
			return true;			
		}else{
			return false;
		}
	}

}
