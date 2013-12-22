package com.oose.chessgame.darkchessman;

import android.graphics.Bitmap;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackElephant extends DarkChessMan{

	private static final long serialVersionUID = 587763541630849072L;

	public BlackElephant(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	public BlackElephant(BlackElephant be) {
		super(be);
	}
	
	@Override
	public BlackElephant clone() throws CloneNotSupportedException {
		return new BlackElephant(this);
	}
	@Override
	public Bitmap getIcon() {
		return DarkChessPictureList.getIcon(this.getClass().getName());
	}

	@Override
	public Bitmap getSelectedIcon() {
		return DarkChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;

	}

	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
