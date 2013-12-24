package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackSoldier extends ChineseChessMan {

	private static final long serialVersionUID = -7365495055614093258L;
	public BlackSoldier(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	
	public BlackSoldier(BlackSoldier bs) {
		super(bs);
	}
	
	@Override
	public BlackSoldier clone() throws CloneNotSupportedException {
		return new BlackSoldier(this);
	}
	
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) { 
		if (currentY <= 4) {// 過河前
			if (y - currentY  == 1 && x == currentX) {
				inBoardMoveChess(x, y);
				return true;
			}
		} else {// 過河後
			if ((Math.abs(y - currentY) + Math.abs(x - currentX)) == 1 && y >= currentY) {
				inBoardMoveChess(x, y);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
