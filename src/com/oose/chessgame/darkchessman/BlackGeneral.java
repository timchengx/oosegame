package com.oose.chessgame.darkchessman;


import android.graphics.Bitmap;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackGeneral extends DarkChessMan {

	private static final long serialVersionUID = -125460878316517268L;
	public BlackGeneral(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}

	
	public BlackGeneral(BlackGeneral bg) {
		super(bg);
	}
	
	@Override
	public BlackGeneral clone() throws CloneNotSupportedException {
		return new BlackGeneral(this);
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
	}
	@Override
	public boolean eat(int x, int y) {
		return move(x,y);
	}

}
