package com.oose.chessgame.darkchessman;

import android.graphics.Bitmap;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackCar extends DarkChessMan{
	
	private static final long serialVersionUID = 2267427798908938020L;
	public BlackCar(int x, int y,  DarkChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	public BlackCar(BlackCar bc) {
		super(bc);
	}
	
	@Override
	public BlackCar clone() throws CloneNotSupportedException {
		return new BlackCar(this);
	}
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;

	}
	public boolean eat(int x, int y) {
		return move(x, y);
	}
}
