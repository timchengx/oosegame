package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackElephant extends ChineseChessMan{

	private static final long serialVersionUID = 587763541630849072L;

	public BlackElephant(int x, int y, ChineseChessBoard board) {
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
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	@Override
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if (5 <= x && x <= 9 && 0 <= y && y <= 8)
//			if (Math.abs((currentX - x)) == 2 && Math.abs((currentY - y)) == 2)
//				if (!board.hasChess((x + currentX) / 2, (y + currentY) / 2))
//					return true;
//
//		return false;
	}

	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
