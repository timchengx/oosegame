package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackShi extends ChineseChessMan {

	public BlackShi(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if(((0<=x && x<=2) || (7<=x && x<=9)) && (3<=y && y<=5))
//		{
//			if((Math.abs(x-currentX) == 1) && (Math.abs(y-currentY) == 1))
//			{
//				return true;
//			}
//		}
//		return false;
	}
	@Override
	public boolean eat(int x, int y) {
		return move(x,y);
	}

}
