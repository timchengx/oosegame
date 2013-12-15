package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class BlackSoldier extends ChineseChessMan {

	public BlackSoldier(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	@Override
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	@Override
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName()+"SELECTED");
	}
	public boolean moveValid(int x, int y) { 
		return true;
//		if(currentX == x && currentX <= 4) {
//			if(Math.abs(currentY-y) == 1 ) { 
//				return true;
//			}
//		}
//		else if (currentY == y){  
//			if(currentX > x) {
//				if((currentX - 1) == x) {
//				 return true;
//				}
//			}
//		}
//		return false;
	}
	public boolean eatValid(int x, int y) {
		return true;
//		if(moveValid(x, y) == true){
//			return true;			
//		}else{
//			return false;
//		}
	}

}
